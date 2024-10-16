package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
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

                if(value <= 0) throw new IllegalArgumentException("Invalid input value!");

                num[i] = value;
                sum += num[i];
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
