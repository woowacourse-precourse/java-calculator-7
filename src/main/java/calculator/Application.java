package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        // System.out.println("입력된 문자열 : " + input); // 입력된 문자열 확인용 코드
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }
        try {
            validateInput(input);  // 유효성 검사
            int[] numbers = extractNumbers(input);  // 숫자 분리
            int result = addNumbers(numbers);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            throw e; // 프로그램 종료
        }
    }

    private static int addNumbers(int[] input) {
        int total = 0;
        for (int number : input) {
            total += number;
        }
        return total;
    }

    private static void validateInput(String input) {
        // 유효성 case 1: "//"로 시작하는 경우
        if (input.startsWith("//")) {
            // 3번 인덱스가 '\'인지, 4번 인덱스가 'n' 인지 확인
            if (input.charAt(3) != '\\' || input.charAt(4) != 'n') {
                throw new IllegalArgumentException();
            }
            // 2번 인덱스 위치에 숫자가 있는 경우 예외 처리
            if (Character.isDigit(input.charAt(2))) {
                throw new IllegalArgumentException();
            }
        } else { // 유효성 case 2: "//"로 시작하지 않는 경우
            for (char c : input.toCharArray()) {
                if (!Character.isDigit(c) && c != ',' && c != ':') {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private static int[] extractNumbers(String input) {
        String[] numberStrings;

        // "//"로 시작하는 경우
        if (input.startsWith("//")) {
            // 커스텀 구분자 추출
            String customDelimiter = String.valueOf(input.charAt(2)); // 인덱스 2의 문자만 추출
            String numbersPart = input.substring(5); // 숫자 부분을 인덱스 5부터 문자열 끝까지 추출

            numberStrings = numbersPart.split("[,:" + customDelimiter + "]+");
        } else { // "//"로 시작하지 않는 경우
            numberStrings = input.split("[,:" + "]+");
        }

        return convertStringToInt(numberStrings);
    }

    private static int[] convertStringToInt(String[] numberStrings) {
        int[] tempArray = new int[numberStrings.length]; // 임시 배열
        int count = 0; // 저장한 숫자의 개수

        for (String s : numberStrings) {
            if (!s.isEmpty()) { // 빈 문자열 필터링
                tempArray[count++] = Integer.parseInt(s); // 정수 변환 후 저장
            }
        }

        // 숫자의 개수에 맞는 새로운 배열 생성
        int[] resultArray = new int[count];

        // tempArray 에서 숫자가 저장된 부분만 복사
        for (int i = 0; i < count; i++) {
            resultArray[i] = tempArray[i];
        }
        return resultArray;
    }
}
