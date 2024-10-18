package calculator;


import camp.nextstep.edu.missionutils.Console;

public class Application {


    public static String[] StringSplit(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ':' || ch == ',') {
                result.append("|");
            } else {
                result.append(ch);
            }
        }
        return result.toString().split("\\|");
    }

    public static int calculator(String input) {
        int sum = 0;
        String[] number = StringSplit(input);

        for (String numbers : number) {
            sum += Integer.parseInt(numbers); // 문자열을 숫자로 변환하여 더하기
        }
        return sum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String SeparatorWithNum = Console.readLine();

        int sum = calculator(SeparatorWithNum);

        System.out.println("결과 : " + sum);
    }
}

