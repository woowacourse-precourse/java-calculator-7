package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String input = getInput();
        int result = processInput(input);
        printOutput(result);
    }

    private static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private static int processInput(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int sum;
        int[] numbers;
        String delimiter = ",|:";  // 기본 구분자


        // 커스텀 구분자가 있는지 확인하고 처리
        if (checkCustomDelimiter(input)) {
            delimiter = addCustomDelimiter(delimiter, input);  // 기본 구분자에 커스텀 구분자 추가
            // 1. \n이 포함되어 있는지 확인
            if (input.contains("\n")) {
                input = input.substring(input.indexOf("\n") + 1);
            }
            // 2. \\n이 포함되어 있는지 확인
            else if (input.contains("\\n")) {
                input = input.substring(input.indexOf("\\n") + 2);
            }
            // 3. 둘 다 없을 때 새로운 문장을 받기
            else {
                input = Console.readLine();
            }
            if (input == null || input.isEmpty()) {
                return 0;
            }
        }
        // 문자열을 구분자로 분리하여 숫자 배열 추출
        numbers = extractNumbers(input, delimiter);
        sum = Arrays.stream(numbers).sum();  // 숫자들 합 계산
        return sum;  // 합 반환
    }

    private static boolean checkCustomDelimiter(String input) {
        return input.startsWith("//");
    }


    private static String addCustomDelimiter(String delimiter, String input) {
        StringBuilder delimiterBuilder = new StringBuilder(delimiter);

        // input의 두 번째 문자 이후 모든 문자를 구분자로 추가
        for (int i = 2; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '\\') {
                if( i+1 < input.length() && input.charAt(i+1) == 'n'){
                    break;
                }
                delimiterBuilder.append("|\\\\");
            } else {
                delimiterBuilder.append("|").append(currentChar);
            }
        }
        return delimiterBuilder.toString();  // 수정된 구분자 반환
    }


    private static int[] extractNumbers(String input, String delimiter) {
        String[] tokens = input.split(delimiter);  // 구분자를 사용해 문자열 분리
        return Arrays.stream(tokens)
                .mapToInt(token -> {
                    String trimmedToken = token.trim();
                    if (trimmedToken.startsWith("-")) {  // 음수인지 확인
                        throw new IllegalArgumentException("Invalid number: " + trimmedToken);
                    }
                    try {
                        return Integer.parseInt(trimmedToken);  // 숫자 변환
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid number: " + trimmedToken);
                    }
                })
                .toArray();
    }


    private static void printOutput(int result) {
        System.out.println("결과 : " + result);
    }
}
