package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            System.out.println(0);
        } else if (input.startsWith("//")) {
            int targetIndex = input.indexOf('\n');
            if (targetIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            } else {
                String custom = input.substring(2, targetIndex);
                String numbers = input.substring(targetIndex + 1);
                String[] splitedNumber = numbers.split(custom);
                int customSum = 0;
                for (String s : splitedNumber) {
                    customSum += Integer.parseInt(s);
                }
                System.out.println(customSum);
            }
        } else {
            String[] splited = input.split("[,|:]");
            int sum = 0;
            for (String s : splited) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }


    }
}
