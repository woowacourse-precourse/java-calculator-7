package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SeparatorManager {
    private final ArrayList<String> separators;
    private String numberString;

    public SeparatorManager() {
        this.separators = new ArrayList<>(Arrays.asList(",", ":"));
    }

    public void processInput(String input) {
        if (!input.startsWith("//") || !input.contains("\\n")) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }

        ArrayList<String> parts = new ArrayList<>(Arrays.asList(input.split("\\\\n")));

        String customSeparators = parts.get(0).substring(2).trim();

        for (String separator : customSeparators.split("[,\\:]")) {
            if (separator.trim().matches("\\d+")) { // 숫자 형식 체크
                throw new IllegalArgumentException("구분자는 숫자가 될 수 없습니다: ");
            }
        }

        numberString = parts.get(1);

        ArrayList<String> customSeparatorList = new ArrayList<>(Arrays.asList(customSeparators.split("[,\\:]")));
        separators.addAll(customSeparatorList);
    }

    public String getNumberString() {
        return numberString;
    }

    public String[] split(String input) {
        String regex = String.join("|", separators.stream()
                .map(this::escapeSeparator)
                .collect(Collectors.toList()));
        return input.split(regex);
    }

    private String escapeSeparator(String separator) {
        return separator.replaceAll("([\\\\*+\\[\\](){}.^$|?])", "\\\\$1");
    }
}