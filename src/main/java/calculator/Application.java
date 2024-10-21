package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String input;
        input = readLine();

        int result = 0;
        String[] numbers;
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }
        StringBuilder seperator = new StringBuilder("[,:]");
        if (input.contains("//") && input.contains("\\n")) {
            String[] dividedInput = input.split("\\\\n");
            String customSeparator = dividedInput[0].substring(2);
            seperator.insert(1, customSeparator);
            numbers = dividedInput[1].split(seperator.toString());
        }
        else{
            numbers = input.split(seperator.toString());
        }

        int[] intArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) intArray[i] = Integer.parseInt(numbers[i].trim());

       for (int num : intArray) result += num;
       System.out.println("결과 : " + result);

    }
}
