package calculator;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
        public static void main(String[] args) {
                System.out.println("덧셈할 문자열을 입력해 주세요.");
                delimiterHandler(readLine());
        }

        private static void delimiterHandler(String input) {
                if (input.isEmpty()) {
                        throw new IllegalArgumentException("입력이 비어 있습니다.");
                }

                String specialChars;
                int start, end;

                if (input.startsWith("//")) {
                        start = input.indexOf("//") + 2;
                        end = input.indexOf("\\n");
                        specialChars = input.substring(start, end);
                        input = input.substring(end + 2); // 숫자 부분만 남김
                } else {
                        specialChars = ",:";
                }

                int result = processNumbers(input, specialChars);
                System.out.println(result);
        }

        private static int processNumbers(String input, String specialChars) {
                int result = 0;
                StringBuilder currentNumber = new StringBuilder();

                for (int i = 0; i < input.length(); i++) {
                        char currentChar = input.charAt(i);

                        // 현재 문자가 숫자인지 확인
                        if (Character.isDigit(currentChar)) {
                                currentNumber.append(currentChar); // 숫자를 문자열로 추가
                        } else if (specialChars.indexOf(currentChar) != -1) {
                                // 숫자가 아닌 경우, 현재까지의 숫자를 정수로 변환하고 결과에 더함
                                if (!currentNumber.isEmpty()) {
                                                int number = Integer.parseInt(currentNumber.toString());
                                                result += number;
                                        currentNumber.setLength(0); // StringBuilder 초기화
                                }
                        }
                        else {
                                throw new IllegalArgumentException("지정된 구분 문자 외의 문자가 입력되었습니다.");
                        }
                }
                        // 마지막에 남아있는 숫자 처리
                        if (!currentNumber.isEmpty()) {
                                result += Integer.parseInt(currentNumber.toString());
                        }

                        return result;
                }
}
