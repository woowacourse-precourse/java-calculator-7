package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String str = Console.readLine();

            String[] parts = str.split("\\\\n");
            String delimiter = ",|:";
            String numbers = parts[0];

            if (numbers.startsWith("//")) {
                delimiter = delimiter + "|" + numbers.charAt(2);
                numbers = parts[1];
            }

            String[] number = numbers.split(delimiter);

            int[] num = new int[number.length];

            int sum = 0;

            for (int i = 0; i < number.length; i++) {
                int value = Integer.parseInt(number[i]);

                if(value <= 0) throw new IllegalArgumentException("잘못된 입력값입니다!");

                num[i] = value;
                sum += num[i];
            }

            System.out.println("결과 : " + sum);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
