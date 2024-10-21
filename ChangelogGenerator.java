import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ChangelogGenerator {

    public static void main(String[] args) {
        try {
            String lastTag = getLastTag();
            String log = getGitLog(lastTag);
            List<Commit> commits = parseCommits(log);
            String changelog = generateChangelog(commits, lastTag);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("CHANGELOG.md"))) {
                writer.write(changelog);
            }

            System.out.println("CHANGELOG.md has been generated.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getLastTag() throws IOException {
        Process process = Runtime.getRuntime().exec("git describe --tags --abbrev=0");
        return new String(process.getInputStream().readAllBytes()).trim();
    }

    private static String getGitLog(String sinceTag) throws IOException {
        String cmd = sinceTag != null ?
                String.format("git log %s..HEAD --pretty=format:%%h%%n%%s%%n%%b%%n==END==", sinceTag) :
                "git log --pretty=format:%h%n%s%n%b%n==END==";
        Process process = Runtime.getRuntime().exec(cmd);
        return new String(process.getInputStream().readAllBytes());
    }

    private static List<Commit> parseCommits(String log) {
        List<Commit> commits = new ArrayList<>();
        String[] commitStrings = log.split("==END==\n");
        for (String commitString : commitStrings) {
            if (!commitString.trim().isEmpty()) {
                commits.add(parseCommitMessage(commitString));
            }
        }
        return commits;
    }

    private static Commit parseCommitMessage(String commit) {
        String[] lines = commit.split("\n");
        String hash = lines[0];
        String subject = lines[1];
        String body = String.join("\n", Arrays.copyOfRange(lines, 2, lines.length));

        Pattern pattern = Pattern.compile("^(\\w+)(\\(([^)]+)\\))?: (.+)$");
        Matcher matcher = pattern.matcher(subject);
        String type, scope, description;
        if (matcher.find()) {
            type = matcher.group(1);
            scope = matcher.group(3);
            description = matcher.group(4);
        } else {
            type = "other";
            scope = null;
            description = subject;
        }

        boolean breaking = body.contains("BREAKING CHANGE:");
        List<String> closes = new ArrayList<>();
        Matcher closeMatcher = Pattern.compile("Closes #(\\d+)").matcher(body);
        while (closeMatcher.find()) {
            closes.add(closeMatcher.group(1));
        }

        return new Commit(hash, type, scope, description, breaking, closes, body);
    }

    private static String generateChangelog(List<Commit> commits, String lastTag) {
        StringBuilder changelog = new StringBuilder();
        changelog.append("# Changelog\n\n");
        changelog.append("## [Unreleased] - ").append(LocalDate.now()).append("\n\n");

        List<Commit> breaking = commits.stream().filter(c -> c.isBreaking()).collect(Collectors.toList());
        List<Commit> features = commits.stream().filter(c -> "feat".equals(c.getType())).collect(Collectors.toList());
        List<Commit> fixes = commits.stream().filter(c -> "fix".equals(c.getType())).collect(Collectors.toList());
        List<Commit> docs = commits.stream().filter(c -> "docs".equals(c.getType())).collect(Collectors.toList());
        List<Commit> others = commits.stream().filter(c -> !c.isBreaking() && !"feat".equals(c.getType()) && !"fix".equals(c.getType()) && !"docs".equals(c.getType())).collect(Collectors.toList());

        if (!breaking.isEmpty()) {
            changelog.append("### ⚠ BREAKING CHANGES\n\n");
            for (Commit change : breaking) {
                changelog.append(formatCommit(change)).append("\n");
                changelog.append("\n").append(change.getBody().trim()).append("\n\n");
            }
            changelog.append("\n");
        }

        appendSection(changelog, "### Features\n\n", features);
        appendSection(changelog, "### Bug Fixes\n\n", fixes);
        appendSection(changelog, "### Documentation\n\n", docs);
        appendSection(changelog, "### Other Changes\n\n", others);

        changelog.append("\n\nFull Changelog: https://github.com/your-repo/compare/").append(lastTag).append("...HEAD\n");
        return changelog.toString();
    }

    private static void appendSection(StringBuilder changelog, String header, List<Commit> commits) {
        if (!commits.isEmpty()) {
            changelog.append(header);
            for (Commit commit : commits) {
                changelog.append(formatCommit(commit)).append("\n");
            }
            changelog.append("\n");
        }
    }

    private static String formatCommit(Commit commit) {
        StringBuilder msg = new StringBuilder("- ");
        if (commit.getScope() != null) {
            msg.append("**").append(commit.getScope()).append(":** ");
        }
        msg.append(commit.getDescription()).append(" (").append(commit.getHash()).append(")");
        if (!commit.getCloses().isEmpty()) {
            msg.append(" (Closes: ").append(String.join(", ", commit.getCloses().stream().map(i -> "#" + i).collect(Collectors.toList()))).append(")");
        }
        return msg.toString();
    }

    private static class Commit {
        private final String hash;
        private final String type;
        private final String scope;
        private final String description;
        private final boolean breaking;
        private final List<String> closes;
        private final String body;

        public Commit(String hash, String type, String scope, String description, boolean breaking, List<String> closes, String body) {
            this.hash = hash;
            this.type = type;
            this.scope = scope;
            this.description = description;
            this.breaking = breaking;
            this.closes = closes;
            this.body = body;
        }

        public String getHash() {
            return hash;
        }

        public String getType() {
            return type;
        }

        public String getScope() {
            return scope;
        }

        public String getDescription() {
            return description;
        }

        public boolean isBreaking() {
            return breaking;
        }

        public List<String> getCloses() {
            return closes;
        }

        public String getBody() {
            return body;
        }
    }
}