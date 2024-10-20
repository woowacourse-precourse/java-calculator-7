package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();

        String input = app.calculateSumFromInput();

        int sum = app.sumInString(input);

//      System.out.println("추출된 숫자: " + result.toString()); // 출력: -1, 77, -33
        app.printResult(sum);
    }

    // 문자열에 음수가 포함된 경우 IllegalArgumentException 발생
    public void checkForNegativeNumbers(char c, int i, String input) {
        // 음수 기호 '-'를 확인하고, 다음 문자가 숫자인 경우 음수로 처리
        if (c == '-' && i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
            throw new IllegalArgumentException("음수가 포함된 입력: " + input);
        }
    }

    public String calculateSumFromInput() {
        //        a-1b77c-33
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public int sumInString(String input) {
        // 숫자 추출 및 합산 로직을 수행
        // 숫자와 부호를 추출하기 위한 StringBuilder
        StringBuilder currentNumber = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // 문자열에 음수가 포함된 경우 예외 발생
            checkForNegativeNumbers(c, i, input);

            sum = numFindInString(c, sum, currentNumber, result);
        }

        return sum;
    }

    public int numFindInString(char c, int sum, StringBuilder currentNumber, StringBuilder result) {

        if (Character.isDigit(c)) {
            currentNumber.append(c);
        } else {
            sum = findTheTotal(sum, currentNumber, result);
        }

        sum = findTheTotal(sum, currentNumber, result);

        return sum;
    }

    public int findTheTotal(int sum, StringBuilder currentNumber, StringBuilder result) {
        if (currentNumber.length() > 0) {
            String numStr = currentNumber.toString();
            int number = Integer.parseInt(numStr);
            sum += number;

            // 결과 문자열에 추가
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(numStr);

            // StringBuilder 초기화
            currentNumber.setLength(0);
        }

        return sum;
    }

    public void printResult(int sum) {
        System.out.println("결과 : " + sum); // 출력 -> 결과 : 43
    }
}
