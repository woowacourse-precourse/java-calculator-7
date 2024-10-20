package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static int calculate(String str) {
        // null, 빈 문자 처리
        if (str == null || str.isEmpty() || str.isBlank()) { // null 처리
            throw new IllegalArgumentException("빈 문자는 허용되지 않습니다.");
        }

        // 문자 앞뒤 공백 허용(예시: " 1,2")
        String numbersPart = str.trim();

        // 기본 구분자
        List<Character> delimiterList = new ArrayList<>();
        delimiterList.add(',');
        delimiterList.add(':');

        // 커스텀 구분자 추가(한 글자로 제한함)
        if (numbersPart.startsWith("//")) {
            int newlineIndex = numbersPart.indexOf("\\n");
            if (newlineIndex != 3) { // "//x\n" 형식 검증
                throw new IllegalArgumentException("커스텀 구분자 지정이 잘못되었습니다.");
            }
            char customDelimiter = numbersPart.charAt(2); // "//x\n"에서 'x' 추출
            delimiterList.add(customDelimiter);
            numbersPart = numbersPart.substring(newlineIndex + 2); // "//x\n1x2"에서 "1x2"로 변환
        }

        // 숫자 분리해서 합 구하기
        String[] strings = splitByDelimiters(numbersPart, delimiterList);
        if (strings.length == 0) {
            throw new IllegalArgumentException("계산될 숫자가 필요합니다.");
        }
        return calculateSum(strings);
    }

    private static int calculateSum(String[] strings) {
        int sum = 0;
        try {
            for (String string : strings) {
                int number = Integer.parseInt(string);
                if (number <= 0) {
                    throw new IllegalArgumentException("양수가 아닌 숫자는 허용되지 않습니다.");
                }
                sum = Math.addExact(sum, number); // overflow 발생 시 ArithmeticException 반환
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자를 숫자로 변환하는 과정에서 문제가 발생하였습니다.");
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("합계가 정수의 최대값을 초과했습니다.");
        }
        return sum;
    }

    /**
     * 구분자 리스트를 기반으로 문자열을 분리하여 배열로 반환합니다. 예를 들어, str이 "apple,banana+carrot"이고 delimiters가 [',','+']인
     * 경우 {"apple","banana","carrot"}을 반환합니다.
     * @param str 대상 문자열
     * @param delimiters 구분자 리스트
     * @return 분리된 문자열 배열
     */
    private static String[] splitByDelimiters(String str, List<Character> delimiters) {
        // 맨뒤 문자가 계산 대상이 맞는지 확인합니다. split 메서드는 마지막 구분자 뒤에 아무것도 없는 경우 예외를 던지지 않습니다.
        String lastStr = str.substring(str.length() - 1);
        if (!isNumeric(lastStr) || delimiters.contains(lastStr.charAt(0))) {
            throw new IllegalArgumentException("문자의 형식이 잘못되었습니다.");
        }

        String regex = buildDelimitersRegex(delimiters);
        return str.split(regex);
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 구분자에 의한 문자열 분리에 사용될 정규표현식을 생성합니다.
     * @param delimiters 문자열 구분자 리스트
     * @return 문자열 분리에 사용될 정규표현식
     */
    private static String buildDelimitersRegex(List<Character> delimiters) {
        StringBuilder regexBuilder = new StringBuilder();
        for (Character delimiter : delimiters) {
            if (!regexBuilder.isEmpty()) {
                regexBuilder.append("|"); // 이전에 구분자가 있었다면 or 연산자 추가
            }
            // 메타문자 처리
            if ("\\.^$|?*+()[]{}".indexOf(delimiter) != -1) {
                regexBuilder.append("\\").append(delimiter);
            } else {
                regexBuilder.append(delimiter);
            }
        }
        return regexBuilder.toString();
    }
}
