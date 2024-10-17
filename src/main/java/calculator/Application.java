package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // extended 모드 확인
        boolean extendedMode = false;
        if (input.length() >= 5 && input.charAt(0) == '/' && input.charAt(1) == '/' &&
                input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            extendedMode = true;
        }

        System.out.println("Extended Mode: " + extendedMode);

        try {
            // 입력된 문자열을 처리하고 결과를 출력
            BigInteger result = processInput(input, extendedMode);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    // 입력 문자열을 처리하는 함수
    private static BigInteger processInput(String input, boolean extendedMode) {
        // 입력 문자열의 길이가 0일 경우 0 반환
        if (input.length() == 0) {
            return BigInteger.ZERO;
        }

        // 2개 이상의 연속된 문자가 숫자가 아닐 경우 오류 발생
        String substringToCheck = extendedMode && input.length() > 5 ? input.substring(5) : input;
        if (substringToCheck.matches(".*[^0-9]{2,}.*")) {
            throw new IllegalArgumentException("입력 문자열에 2개 이상의 연속된 숫자가 아닌 문자가 포함되어 있습니다.");
        }

        // 기본 구분자 배열
        String delimiters = ",:";

        // extended 모드일 경우 추가 구분자 설정
        if (extendedMode && input.length() > 2) {
            char additionalDelimiter = input.charAt(2);
            delimiters += additionalDelimiter;
        }

        // 문자열을 한 자리씩 순환하면서 구분자 배열을 기반으로 검사
        int startIndex = extendedMode ? 5 : 0;
        for (int i = startIndex; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c) && delimiters.indexOf(c) == -1) {
                throw new IllegalArgumentException("입력 문자열에 허용되지 않은 문자가 포함되어 있습니다: " + c);
            }
        }

        // 문자열의 맨 앞과 맨 뒷 부분이 숫자인지 확인
        if (extendedMode) {
            if (input.length() <= 5 || !Character.isDigit(input.charAt(5)) || !Character.isDigit(
                    input.charAt(input.length() - 1))) {
                throw new IllegalArgumentException("Extended 모드에서는 5번째 자리와 맨 끝의 문자가 숫자여야 합니다.");
            }
        } else {
            if (!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(input.length() - 1))) {
                throw new IllegalArgumentException("입력 문자열의 맨 앞과 맨 뒷 부분은 숫자여야 합니다.");
            }
        }

        // 올바른 문자열을 기준으로 숫자의 합을 계산
        return sumNumbers(input, extendedMode);
    }

    // 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 분리하고 합을 계산하는 함수
    private static BigInteger sumNumbers(String input, boolean extendedMode) {
        // 기본 구분자 배열
        String delimiters = "[,:]";

        // extended 모드일 경우 추가 구분자 설정
        if (extendedMode && input.length() > 2) {
            char additionalDelimiter = input.charAt(2);
            delimiters = "[,:" + additionalDelimiter + "]";
        }

        // extended 모드일 경우 5번째 문자부터 처리
        String substringToProcess = extendedMode && input.length() > 5 ? input.substring(5) : input;

        String[] numbers = substringToProcess.split(delimiters);
        BigInteger sum = BigInteger.ZERO;
        for (String number : numbers) {
            sum = sum.add(new BigInteger(number));
        }
        return sum;
    }
}
