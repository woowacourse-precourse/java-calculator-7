package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    private String inputString;
    private List<String> delimiterList = new ArrayList<>();
    private List<Integer> extractedNumList = new ArrayList<>();

    NumberParser(String inputString) {
        this.inputString = inputString;
        delimiterList.add(",");
        delimiterList.add(":");
        extractDelimiter();
        extractNum();
    }

    // 커스텀 구분자 추출
    private void extractDelimiter() {
        if (!inputString.startsWith("//")) {
            return;
        }

        // 커스텀 구분자와 본문을 분리
        int delimiterStartIndex = inputString.indexOf("//") + 2;
        int delimiterEndIndex = inputString.indexOf("\\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("잘못된 구분자 입력 형식입니다.");
        }

        // 커스텀 구분자를 추출하여 delimiterList에 추가
        String customDelimiter = inputString.substring(delimiterStartIndex, delimiterEndIndex);
        delimiterList.add(customDelimiter);

        // 본문에서 구분자 정의 부분 제거
        inputString = inputString.substring(delimiterEndIndex + 2);
    }

    // 숫자 추출
    private void extractNum() {
        // 구분자를 사용해 문자열을 분리
        String regex = String.join("|", delimiterList.stream().map(d -> "\\Q" + d + "\\E").toArray(String[]::new));
        String[] numberStrings = inputString.split(regex);

        // 숫자를 리스트에 저장
        for (String numberString : numberStrings) {
            try {
                int number = Integer.parseInt(numberString.trim());
                extractedNumList.add(number);
            } catch (NumberFormatException e) {
                // 예외 처리: 숫자가 아닌 값이 있을 경우 예외 발생
                throw new IllegalArgumentException("유효하지 않은 숫자가 포함되어 있습니다: " + numberString);
            }
        }
    }

    public List<Integer> getExtractedNumList() {
        return extractedNumList;
    }
}
