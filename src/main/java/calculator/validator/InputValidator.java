package calculator.validator;

public class InputValidator {
    public static void validateInput(String input) {
        if (input == null){
            throw new IllegalArgumentException("input은 null일 수 없습니다.");
        }
        if (input.startsWith("//")){
            validateCustomDelimiterFormat(input);
        }
    }

    public static void validateNumber(String number) {
        try {
            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 0){
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식: " + number);
        }
    }

    private static void validateCustomDelimiterFormat(String input) {
        if(!input.contains("\n")){
            throw new IllegalArgumentException("불가능한 custom delimiter 형식");
        }

        String[] parts = input.split("\n", 2);
        if (parts[0].length() <=2){
            throw new IllegalArgumentException("불가능한 custom delimiter 형식");
        }
    }
}
