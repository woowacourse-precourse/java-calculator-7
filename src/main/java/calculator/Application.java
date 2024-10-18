package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String userInput = Console.readLine();
        Console.close();
        int[] integerArr = new int[512];
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < userInput.length(); i++) {
            char inputChar = userInput.charAt(i);
            if (Character.isDigit(inputChar)) {
                integerArr[idx++] = inputChar - '0';
            } else if (inputChar == ',' || inputChar == ':') {
                continue;
            }else {
                throw new IllegalArgumentException();
            }
        }
        for (int i : integerArr) {
            sum += i;
        }
        System.out.println("결과 : " + sum);
    }
}
