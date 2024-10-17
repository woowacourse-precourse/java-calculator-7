package calculator;

public class Converter {

    private final InputValidator inputValidator = new InputValidator();
    private static final String SEPARATOR = ",|:";

    public String[] toStringArr(String input) {

        if (inputValidator.isCustomPattern(input)) {
            String customPattern = String.valueOf(input.charAt(2));
            String numbers = input.substring(5);

            String[] split = numbers.split(customPattern);

            for (String s : split) {
                System.out.println("s = " + s);
            }

            return split;
        }

        inputValidator.isInvalidFormat(input);


        return input.split(SEPARATOR);
    }


}
