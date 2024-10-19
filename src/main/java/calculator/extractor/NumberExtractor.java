package calculator.extractor;

import java.util.ArrayList;

public class NumberExtractor {
    public static ArrayList<Character> separators = new ArrayList<>();

    // 초기값 삽입
    static {
        separators.add(',');
        separators.add(':');
    }

    /**
     * 문자열에서 숫자 배열 추출
     */
    public static ArrayList<Integer> extractNumberList(String inputData) {
        // 1. 커스텀 구분자 존재 유무 파악
        // - 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
        if(inputData.startsWith("//") && inputData.charAt(3) == '\\' && inputData.charAt(4) == 'n') {
            char customSeparator = inputData.charAt(2);
            separators.add(customSeparator);

            // 입력 문자열에서 커스텀 구분자 선언문 제거
            inputData = inputData.substring(5);
        }

        // 분리를 위한 정규표현식 생성
        // 2. 구분자 배열로 문자열 분리
        String regex = createRegexFromSeparators();

        // 2. 구분자 배열로 문자열 분리
        String[] splitArray = inputData.split(regex.toString());
        ArrayList<Integer> extractedNumber = new ArrayList<>();
        for (String string : splitArray) {
            if (string.equals("")) { // 분리된 결과가 "" 이라면 0으로 저장 ex) 3;;4
                extractedNumber.add(0);
                continue;
            }
            // 3. 분리된 문자가 숫자가 아니거나, 양수가 아니라면 IllegalArgumentException 발생 후 어플리케이션 종료
            try {
                int num = Integer.parseInt(string);
                if (num > 0) // 양수인 경우에만 추출 숫자 리스트에 삽입
                    extractedNumber.add(num);
            } catch (Exception e) {
                throw new IllegalStateException();
            }
        }
        return extractedNumber;
    }

    // 문자열 추출용 정규표현식 생성
    private static String createRegexFromSeparators() {
        StringBuilder regexBuilder = new StringBuilder();
        for (Character separator : separators) {
            if (regexBuilder.length() > 0) { // 첫문자가 아닌 경우 |로 분리
                regexBuilder.append("|");
            }
            regexBuilder.append(separator);
        }
        return regexBuilder.toString();
    }
}
