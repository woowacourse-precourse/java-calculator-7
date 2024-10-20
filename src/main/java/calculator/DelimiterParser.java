package calculator;

import java.util.HashSet;
import java.util.Set;

public class DelimiterParser {
    private Set<String> delimiters = new HashSet<>();
    private int parseIndex = 0;

    public void addDelimiters(String delimiter) {
        delimiters.add(delimiter);
    }

    public Set<String> getDelimiters() {
        return delimiters;
    }

    public int addParseIndex() {
        return ++parseIndex;
    }

    public int getParseIndex() {
        return parseIndex;
    }

    public int parse(String input) {

        // 커스텀 구분자 있는지 확인
        while (input.length() > 2 && parseIndex + 1 < input.length()
                && input.charAt(parseIndex) == '/' && input.charAt(parseIndex + 1) == '/') {
            parseIndex += 2;  // "//" 스킵
            StringBuilder sepLetter = new StringBuilder();
            boolean endFlagChk = false;

            // 새로운 구분자 추출
            while (parseIndex + 1 < input.length()
                    && !(input.charAt(parseIndex) == '\\' && input.charAt(parseIndex + 1) == 'n')) {
                sepLetter.append(input.charAt(parseIndex));
                parseIndex++;
            }

            // 구분자가 비어 있을 경우 예외 발생
            if (sepLetter.length() == 0) {
                throw new IllegalArgumentException("구분자가 비어 있습니다.");
            }

            // 구분자 끝났는지 확인 후 추가
            if (parseIndex + 1 < input.length() && input.charAt(parseIndex) == '\\' && input.charAt(parseIndex + 1) == 'n') {
                endFlagChk = true;
                parseIndex += 2;  // '\n'을 스킵
            }

            if (endFlagChk) {
                delimiters.add(sepLetter.toString());
            } else {
                throw new IllegalArgumentException("구분자 끝을 찾을 수 없습니다.");
            }
        }

        return parseIndex;
    }
}
