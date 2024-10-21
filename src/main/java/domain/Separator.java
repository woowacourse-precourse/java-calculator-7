package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {
    private final List<String> separatorCollection;

    public Separator(List<String> separatorCollection) {
        this.separatorCollection = new ArrayList<>(separatorCollection);
        defaultSeparator();
    }

    private void defaultSeparator() {
        if (!separatorCollection.contains(",")) {
            separatorCollection.add(",");
        }
        if (!separatorCollection.contains(":")) {
            separatorCollection.add(":");
        }
    }

    public String findAndAddSeparator(String inputString) {
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            String separator = matcher.group(1);
            if (!separatorCollection.contains(separator)) {
                separatorCollection.add(separator);
            }
            return inputString.substring(matcher.end()).trim();
        }
        return inputString.trim();
    }

    public List<Integer> extractionNumbers(String inputString) {
        List<Integer> numberCollection = new ArrayList<>();

        String regex = separatorCollection.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        String[] parts = inputString.split(regex);

        for (String part : parts) {
            part = part.trim();

            if (!part.isEmpty()) {
                try {
                    int number = Integer.parseInt(part);
                    if (number <= 0) {
                        throw new IllegalArgumentException("0 이하의 숫자는 입력할 수 없습니다.");
                    }
                    numberCollection.add(number);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(part + "는 유효한 숫자가 아닙니다.");
                }
            }
        }
        return numberCollection;
    }
}
