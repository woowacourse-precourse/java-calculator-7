package calculator;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
        public static void main(String[] args) {
                System.out.println("덧셈할 문자열을 입력해 주세요.");
                String input = readLine();
                validateInput(input); // 입력 유효성 검사
                int result = calculateSum(input); // 입력된 문자열의 합계 계산
                System.out.println("결과 : " + result); // 결과 출력
        }

        /**
         * 입력된 문자열의 합계를 계산하는 메서드
         *
         * @param input 덧셈할 문자열
         * @return 계산된 합계
         */
        private static int calculateSum(String input) {
                validateInput(input); // 입력 유효성 검사
                String specialChars = extractSpecialChars(input); // 구분 문자 추출
                String numbers = extractNumbers(input); // 숫자 부분 추출
                return sumNumbers(numbers, specialChars); // 숫자의 합계 반환
        }

        /**
         * 입력이 유효한지 검사하는 메서드
         *
         * @param input 검사할 문자열
         * @throws IllegalArgumentException 입력이 비어있거나 음수를 포함할 경우
         */
        private static void validateInput(String input) {
                if (input.isEmpty()) {
                        throw new IllegalArgumentException("입력이 비어 있습니다."); // 빈 입력 검사
                }
                if (input.contains("-")) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다."); // 음수 입력 검사
                }
        }

        /**
         * 입력에서 구분 문자를 추출하는 메서드
         *
         * @param input 입력 문자열
         * @return 구분 문자
         */
        private static String extractSpecialChars(String input) {
                if (input.startsWith("//")) {
                        int start = input.indexOf("//") + 2;
                        int end = input.indexOf("\\n");
                        return input.substring(start, end); // 구분 문자 반환
                }
                return ",:"; // 기본 구분 문자
        }

        /**
         * 입력에서 숫자 부분을 추출하는 메서드
         *
         * @param input 입력 문자열
         * @return 숫자 부분
         */
        private static String extractNumbers(String input) {
                if (input.startsWith("//")) {
                        int end = input.indexOf("\\n");
                        return input.substring(end + 2); // 숫자 부분만 반환
                }
                return input; // 구분 문자가 없는 경우 전체 입력 반환
        }

        /**
         * 입력된 숫자들의 합계를 계산하는 메서드
         *
         * @param input 숫자 문자열
         * @param specialChars 구분 문자
         * @return 계산된 합계
         * @throws IllegalArgumentException 잘못된 문자가 포함된 경우
         */
        private static int sumNumbers(String input, String specialChars) {
                int result = 0;
                StringBuilder currentNumber = new StringBuilder();

                for (char currentChar : input.toCharArray()) {
                        if (Character.isDigit(currentChar)) {
                                currentNumber.append(currentChar); // 숫자 추가
                        } else if (specialChars.indexOf(currentChar) != -1) {
                                result += parseCurrentNumber(currentNumber); // 현재 숫자 합계에 추가
                        } else {
                                throw new IllegalArgumentException("지정된 구분 문자 외의 문자가 입력되었습니다."); // 잘못된 문자 처리
                        }
                }
                result += parseCurrentNumber(currentNumber); // 마지막 숫자 처리
                return result; // 최종 합계 반환
        }

        /**
         * StringBuilder에 저장된 현재 숫자를 정수로 변환하는 메서드
         *
         * @param currentNumber 변환할 숫자
         * @return 변환된 정수
         */
        private static int parseCurrentNumber(StringBuilder currentNumber) {
                int number = 0;
                if (!currentNumber.isEmpty()) {
                        number = Integer.parseInt(currentNumber.toString()); // 숫자로 변환
                        currentNumber.setLength(0); // StringBuilder 초기화
                }
                return number; // 변환된 숫자 반환
        }
}
