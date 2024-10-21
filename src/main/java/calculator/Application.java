package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println("결과 : " + calculate(input));
        Console.close();
    }

    public static int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",:";

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");

            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자의 입력 형식에 맞게 작성해 주세요.");
            } else if (delimiterIndex == 2) {
                throw new IllegalArgumentException("사용할 커스텀 구분자를 입력해 주세요.");
            }

            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 2);
            if (input.isEmpty()) {
                return 0;
            }
        }

        String[] splitInputs = input.split(String.format("[%s]", delimiter));
        int sum = 0;
        for (String splitInput : splitInputs) {
            int number = parseNumber(splitInput);

            if (sum > Integer.MAX_VALUE - number) {
                throw new IllegalArgumentException(
                        String.format("입력한 숫자의 합계가 int의 최대 범위(%d)를 초과하였습니다.", Integer.MAX_VALUE)
                );
            }

            sum += number;
        }
        return sum;
    }

    private static int parseNumber(String splitInput) {
        //1. 정규표현식으로 1자리부터 9자리 숫자를 검증
        if (splitInput.matches("\\d{1,9}")) {
            return Integer.parseInt(splitInput);
        }

        //2. 10자리 숫자 중에서 int 범위의 최대값인 2147483647을 초과하는지 검사
        if (splitInput.matches("\\d{10}")) {
            if (splitInput.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0) {
                throw new IllegalArgumentException(
                        String.format("입력한 숫자(%s)가 int의 최대 범위(%d)를 초과하였습니다.", splitInput, Integer.MAX_VALUE)
                );
            }
            return Integer.parseInt(splitInput); //범위 내이면 변환
        }

        throw new IllegalArgumentException(
                String.format("유효하지 않은 입력입니다(%s). 양의 정수를 입력해 주세요.", splitInput)
        );
    }
}