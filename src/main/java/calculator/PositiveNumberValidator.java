package calculator;

public class PositiveNumberValidator {
    public int addCalculator(String[] tokens) {
        int sum = 0;

        int[] validatedNumbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++){
            validatedNumbers[i] = isNumber(tokens[i]);
        }

        for (int i = 0; i < validatedNumbers.length; i++){
            sum += validatedNumbers[i];
        }

        return sum;

    }
    private int isNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number > 0){
                return number;
            }
            else {
                throw new IllegalArgumentException("The number must be positive " + token);
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format" + token);
        }
    }
}
