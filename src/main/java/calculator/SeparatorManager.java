package calculator;

public class SeparatorManager {
    private static final String customSeparatorStart = "//";
    private static final String customSeparatorEnd = "\\\\n";

    public Separator getSeparator(String originString) {
        Separator separator = new Separator();
        if (originString.startsWith(customSeparatorStart)) {
            separator.addSeparator(extractDelimiter(originString));
        }
        return separator;
    }

    public String extractDelimiter(String input) {
        String[] parts = input.split(customSeparatorEnd, 2);
        return parts[0].substring(2);
    }

    public Number getNumber(Separator separator, String originString) {
        if (originString.startsWith(customSeparatorStart)) {
            originString = separateCustomSeparator(originString);
        }

        String regex = String.join("|", separator.getSeparators().stream()
                .map(sep -> "\\Q" + sep + "\\E")
                .toArray(String[]::new));

        return new Number(originString.split(regex));
    }

    public String separateCustomSeparator(String originString) {
        String[] parts = originString.split(customSeparatorEnd);
        if (parts.length < 2) {
            throw new IllegalArgumentException();
        }
        return parts[1];
    }
}
