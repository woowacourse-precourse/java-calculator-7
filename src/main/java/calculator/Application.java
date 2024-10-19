package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String str = readLine();
        if (str.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }
        if (str.contains("//")){

        }
        String regex = "[:,]";
        String[] numbers = str.split(regex);
        int sum = 0;

        int[] intArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) intArray[i] = Integer.parseInt(numbers[i].trim());

        for (int num : intArray) sum += num;
        System.out.println("결과 : " + sum);

    }
}
