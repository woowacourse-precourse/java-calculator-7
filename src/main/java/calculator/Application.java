package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {

        Separator separator = new Separator();
//        입력받기.
        String input = getInput();

//        //으로 시작하는 경우 커스텀 구분자 추출하기.
        if (input.startsWith("//")) {
            input = separator.extractCustomSeparatorFrom(input);
        }

//        출력하기.
        System.out.print("결과 : " + getSum(separator.getNumbersFrom(input)));


    }

    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요. ");
        return Console.readLine();
    }

    public static int getSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += getValidatedNumber(number);
        }
        return sum;
    }

    public static int getValidatedNumber(String number) {
        if (number.isEmpty()) {
            return 0;
        }

        try {
//            숫자가 아닌 경우 예외 발생
            int num = Integer.parseInt(number.trim());

//            0, 음수일 경우 예외 발생
            if (num <= 0) {
                throw new IllegalArgumentException("음수와 0은 입력할 수 없습니다. ");
            }

            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자와 양수만 입력 가능합니다. ");
        }
    }
}
