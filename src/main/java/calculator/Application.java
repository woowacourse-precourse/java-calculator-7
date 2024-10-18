package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); //사용자입력

        // 입력을 구분자로 나누기
        try {
            String[] parts = splitInput(input);
            int sum = sumNumbers(parts);
            System.out.println("합계: " + sum);
        } catch (IllegalArgumentException e) {
        }

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

    //나눠진 문자들이 전부 숫자인지 확인하는 메서드
    public static boolean isNum(String[] parts) {
        for (String part : parts) {
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) {
                    throw new IllegalArgumentException(); // 숫자가 아닌 문자가 있으면 false
                }
            }
        }
        return true;
    }


}
