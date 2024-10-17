package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); //사용자입력

        String[] parts = splitInput(input); // 입력을 구분자로 나누기
        int sum = sumNumbers(parts); // 숫자들을 더하기
        System.out.println("합계: " + sum);
    }

    // 입력된 문자열을 구분자로 나누는 메서드
    public static String[] splitInput(String input) {
        return input.split("[,:]"); // 콤마와 콜론을 구분자로 사용하여 문자열을 나눔
    }

    //나눠진 문자를 합하는 메서드
    public static int sumNumbers(String[] parts) {
        int sum = 0;

        for (String part : parts) {
            sum += Integer.parseInt(part);
        }
        return sum;
    }


}
