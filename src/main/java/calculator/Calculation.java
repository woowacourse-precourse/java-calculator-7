package calculator;

public class Calculation {
    public static int getCalculationResult(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return calculateString(input);
    }

    public static int calculateString(String input) {
        String result = "";
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            if (Character.isDigit(inputChar)) {
                result += inputChar;
                if (i != (input.length() - 1) && Character.isDigit(input.charAt(i + 1))) {
                    result += input.charAt(i + 1);
                    i++;
                    if (i != (input.length() - 1)) {
                        continue;
                    }
                }
                sum += Integer.parseInt(result);
                result = "";
                continue;
            }
            if (result.isEmpty()) {
                result = "0";
            }
            sum += Integer.parseInt(result);
            result = "";
        }
        return sum;
    }
}
