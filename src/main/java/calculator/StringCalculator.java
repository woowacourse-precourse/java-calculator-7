package calculator;

public class StringCalculator {
    public String[] splitInput(String input) {
        if (input.startsWith("//")) {
            int customIdx = input.indexOf("\n");
            String custom = input.substring(2, customIdx);
            String numberString = input.substring(customIdx + 1);
            return numberString.split(custom);
        }
        return input.split("[,:]");
    }

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] numbers = splitInput(input);
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}