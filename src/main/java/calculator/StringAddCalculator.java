package calculator;

public class StringAddCalculator {

    public static int calculator(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";

        if (input.startsWith("//")) {
            input = input.replaceFirst("//", "");
            input = input.replace("\\n", "\n");

            String[] temp = input.split("\n");
            delimiter += "|" + temp[0];
            input = input.split("\n", 2)[1];
        }

        String[] numbers = input.split(delimiter);

        return sum(numbers);
    }

    static int sum(String[] numbers) {
        int sum = 0;

        for (String number: numbers) {
            int intNum = Integer.parseInt(number);

            if (intNum < 0) {
                throw new IllegalArgumentException();
            }

            sum += intNum;
        }

        return sum;
    }
}
