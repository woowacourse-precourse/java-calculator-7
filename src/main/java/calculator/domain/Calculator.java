package calculator.domain;

import java.util.Arrays;

public class Calculator {
    private static final int CUSTOM_DELIMITER_START_INDEX = 2;
    private static final int CUSTOM_DELIMITER_END_INDEX = 3;
    private static final int CUSTOM_INPUT_START_INDEX = 5;
    private final static String PARSE_ERROR_MESSAGE = "잘못된 값을 입력했습니다.";
    private final String[] formulas;

    public Calculator(){
        this("");
    }

    public Calculator(String input) {
        this.formulas = split(input);
    }

    public String[] split(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            String delimiter = input.substring(CUSTOM_DELIMITER_START_INDEX, CUSTOM_DELIMITER_END_INDEX);
            input = input.substring(CUSTOM_INPUT_START_INDEX);
            return input.split(delimiter);
        }
        return input.split("[,|:]");
    }

    public int sum() {
        return Arrays.stream(formulas).mapToInt(this::parse).sum();
    }


    public int parse(String input) {
        try{
            return validate(Integer.parseInt(input));
        } catch(Exception e) {
            throw new IllegalArgumentException(PARSE_ERROR_MESSAGE);
        }
    }

    private int validate(int number) {
        if(number < 0) {
            throw new IllegalArgumentException();
        }
        return number;
    }
}
