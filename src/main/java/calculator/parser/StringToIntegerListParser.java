package calculator.parser;

import calculator.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class StringToIntegerListParser implements Parser<String, List<Integer>> {

    private static final String CUSTOM_DELIMITERS_START = "//";

    private static final String CUSTOM_DELIMITERS_END = "\n";

    private static final List<Integer> DEFAULT_LIST = List.of(0);

    private final Set<Character> delimiters;

    private final Set<Character> notAllowedDelimiters;

    public StringToIntegerListParser() {
        this.delimiters = new HashSet<>();
        this.delimiters.addAll(List.of(',', ':'));
        this.notAllowedDelimiters = new HashSet<>();
        this.notAllowedDelimiters.addAll(List.of('-', '+', '*', '/'));
    }

    public Set<Character> getDelimiters() {
        return this.delimiters;
    }

    @Override
    public List<Integer> parse(String input) {
        if (input == null || input.isBlank()) {
            return DEFAULT_LIST;
        }
        String inputValue = this.replaceEOL(input);

        Set<Character> customDelimiters = this.extractCustomDelimiters(inputValue);
        String value = this.extractValue(inputValue);
        this.delimiters.addAll(customDelimiters);

        String delimStr = Collections.joinToString(this.delimiters);
        StringTokenizer tokenizer = new StringTokenizer(value, delimStr);
        List<Integer> result = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            this.addOrThrows(result, tokenizer.nextToken());
        }

        return result;
    }

    private String replaceEOL(String input) {
        return input.replace("\\n", "\\\n");
    }

    private Set<Character> extractCustomDelimiters(String input) {
        Set<Character> customs = new HashSet<>();
        int sIndex = 0;
        while ((sIndex = input.indexOf(CUSTOM_DELIMITERS_START, sIndex)) != -1) {
            sIndex += 2;

            int eIndex = input.indexOf(CUSTOM_DELIMITERS_END, sIndex);
            if (eIndex == -1) {
                eIndex = input.length();
            }

            String custom = input.substring(sIndex, eIndex).trim();
            if (!custom.isEmpty()) {
                this.addCustomDelimiters(customs, custom);
            }

            sIndex = eIndex + 1;
        }
        return customs;
    }

    private void addCustomDelimiters(Set<Character> customSet, String custom) {
        char[] customChars = custom.toCharArray();
        Set<Character> customCharacterSet = new HashSet<>();
        for (char c : customChars) {
            if (this.notAllowedDelimiters.contains(c)) {
                throw new IllegalArgumentException(String.format("%s 는 사용할 수 없는 구분자입니다.", c));
            }
            customCharacterSet.add(c);
        }
        customSet.addAll(customCharacterSet);
    }

    private String extractValue(String input) {
        int lastIndex = input.lastIndexOf(CUSTOM_DELIMITERS_END);
        if (lastIndex == -1) {
            return input;
        }
        return input.substring(lastIndex).trim();
    }

    private void addOrThrows(List<Integer> result, String s) {
        try {
            int num = Integer.parseInt(s);
            if (num <= 0) {
                throw new IllegalArgumentException("숫자는 1 이상의 양수만 입력 가능합니다.");
            }
            result.add(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s 는 올바르지 않은 입력값입니다.", s));
        }
    }

}
