package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Calculator {

    private int result; // 결과 도출할 result 선언

    public Calculator(String input){
        calculate(input); // 숫자 추출 및 합산을 메서드 호출
    }

    // 구분자 추가하고 합산하는 메서드
    private void calculate(String input) {

        List<String> delimiters = new ArrayList<>();

        delimiters.add(","); // delimiters에 기본 구분자 추가
        delimiters.add(":"); // delimiters에 기본 구분자 추가

        // findCustomDelimiters로 구분자 추출 및 재설정
//        findCustomDelimiters(input, delimiters);

        validateInput(input, delimiters); // 입력 유효성 검사

        delimiters.add("//");
        delimiters.add("\n");

        result = calculateSum(input, delimiters);
    }

    private static void validateInput(String input, List<String> delimiters) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있거나 null입니다.");
        }

        StringBuilder validChars = new StringBuilder("0123456789");
        for (String delimiter : delimiters) {
            validChars.append(delimiter);
        }

        String processedInput = input;
        int startIndex = 0;
        while (true) {
            int customDelimStart = processedInput.indexOf("//", startIndex);
            if (customDelimStart == -1) {
                break;
            }
            int newLineIndex = processedInput.indexOf("\\n", customDelimStart);
            if (newLineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            String customDelimiter = processedInput.substring(customDelimStart + 2, newLineIndex);
            delimiters.add(customDelimiter);
            validChars.append(customDelimiter);

            // 커스텀 구분자 부분을 제거
            processedInput = processedInput.substring(0, customDelimStart) +
                    processedInput.substring(newLineIndex + 2);
            startIndex = customDelimStart;
        }

        // 모든 구분자 제거
        for (String delimiter : delimiters) {
            processedInput = processedInput.replace(delimiter, "");
        }

        // 유효하지 않은 문자 체크
        for (char c : processedInput.toCharArray()) {
            if (validChars.toString().indexOf(c) == -1) {
                throw new IllegalArgumentException("유효하지 않은 문자가 포함되어 있습니다: " + c);
            }
        }
    }


    public static int calculateSum(String input, List<String> delimiters) {
        // 구분자로 사용할 문자열을 빈 문자열로 초기화
        String result = input;

        // "//"와 "\n" 사이의 값을 ""로 치환
        while (result.contains("//") && result.contains("\n")) {
            int startIndex = result.indexOf("//");
            int endIndex = result.indexOf("\n", startIndex);

            // endIndex가 -1이면 "\n"이 없다는 뜻이므로 종료
            if (endIndex == -1) break;

            // "//"와 "\n" 사이의 값을 ""로 바꾸기
            result = result.substring(0, startIndex) + result.substring(endIndex);
        }

        // 입력 문자열의 각 구분자를 사용하여 문자열을 치환
        for (String delimiter : delimiters) {
            result = result.replace(delimiter, " "); // 구분자를 공백으로 치환
        }

        // 치환된 문자열을 공백을 기준으로 분리
        String[] numbers = result.split(" ");

        String[] replaceNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String str = numbers[i];

            // 숫자만 추출하기
            StringBuilder numBuilder = new StringBuilder();

            for (char ch : str.toCharArray()) {
                if (Character.isDigit(ch)) { // 숫자만 포함
                    numBuilder.append(ch);
                }
            }
            // 결과 저장
            replaceNumbers[i] = numBuilder.toString();
        }

        // 숫자의 합 계산
        int sum = 0;
        for (String number : replaceNumbers) {
            if (!number.isEmpty()) { // 빈 문자열 체크
                int num = Integer.parseInt(number);
                sum += Integer.parseInt(number); // 숫자로 변환 후 더하기
            }
        }
        return sum; // 합 반환
    }

    public int getResult() {
        return result;
    }
}




// 커스텀 구분자를 찾고 입력 정제
//    private static void findCustomDelimiters(String input, List<String> delimiters) {
//        int startIndex = 0;
//
//        // 무한루프
//        while (true) {
//            // //값이 있으면,
//            int customDelimStart = input.indexOf("//", startIndex);
//            if (customDelimStart == -1) {
//                break;
//            }
//
//            int newLineIndex = input.indexOf("\n", customDelimStart);
//            if (newLineIndex == -1) {
//                break;
//            }
//
//            String customDelimiter = input.substring(customDelimStart + 2, newLineIndex);
//            delimiters.add(customDelimiter);
//            startIndex = newLineIndex + 2;
//        }
//    }
