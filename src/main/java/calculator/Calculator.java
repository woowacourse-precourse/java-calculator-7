package calculator;

public class Calculator {
    private static final String COMMA = ",";
    private static final String COLON = ":";

    public int calcString(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }

        if (!input.startsWith("//") && !input.matches("^[0-9, :]*$")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        if(input.startsWith("//")) {
            return calcWithCustom(input);
        }else {
            return calcWithDefault(input);
        }
    }

    private int calcWithDefault(String input) {
        String[] numbers = input.split(COMMA + "|" + COLON);
        return calcSum(numbers);
    }

    private int calcWithCustom(String input) {
        int delimiterEnd = input.indexOf("\\n");

        if (delimiterEnd == -1) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        String delimiter = input.substring(2,delimiterEnd);
        String numbersString = input.substring(delimiterEnd + 2);

        String[] numbers = numbersString.split(delimiter);
        return calcSum(numbers);
    }

    private int calcSum(String[] numbers) {
        int result = 0;

        for(String num : numbers){
            if (!num.matches("\\d+")) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            result += Integer.parseInt(num);
        }

        return result;
    }
}
