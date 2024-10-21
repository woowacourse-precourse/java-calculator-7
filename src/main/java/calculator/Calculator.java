package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculator {
    private String userInput;
    private String customDelimiter;
    private Integer calculateResult;
    private static final String INVALID_INPUT_ERROR = "[ERROR] Invalid input format";

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.+?)\\n(.*)");


    public Calculator() {}

    public Boolean checkInputByRule() {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] user Input is Empty");
        }

        if (userInput.startsWith("//")) {
            String normalizedInput = userInput.replace("\\n", "\n");
            Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(normalizedInput);

            if (!matcher.matches()) {
                throw new IllegalArgumentException("[ERROR] Invalid custom delimiter format");
            }

            customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);

            if (!numbers.matches(".*\\d+.*")) {
                throw new IllegalArgumentException(INVALID_INPUT_ERROR);
            }
        } else {
            if (!userInput.matches("^[0-9,:,\\s]*$")) {
                throw new IllegalArgumentException(INVALID_INPUT_ERROR);
            }
        }
        return true;
    }

    public Integer getSumByCalculate() {
        String defaultDelimiter = ",|:";
        String numbers = userInput;

        if (userInput.startsWith("//")) {
            defaultDelimiter = Pattern.quote(customDelimiter) + "|,|:";
            numbers = userInput.substring(userInput.indexOf("\n") + 1);
        }

        this.calculateResult = Arrays.stream(numbers.split(defaultDelimiter))
                .filter(s -> !s.trim().isEmpty())
                .filter(s -> s.matches(".*\\d+.*"))
                .mapToInt(this::parsePositiveInt)
                .sum();

        return this.calculateResult;
    }

    private int parsePositiveInt(String str) {
        str = str.trim();
        try {
            str = str.replaceAll("[^0-9]", "");
            int num = Integer.parseInt(str);
            if (num < 0) {
                throw new IllegalArgumentException("[ERROR] Negative numbers are not allowed: " + num);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] formatException");
        }
    }

    public String setUserInputByCustomConsole() {
        try {
            this.userInput = Console.readLine();
            return this.userInput;
        } catch (OutOfMemoryError e) {
            throw new IllegalArgumentException("[ERROR] Out of memory", e);
        }
    }
    public void resultShowConsole() {
        System.out.println("결과 : " + this.calculateResult);
    }

    public String resultShowConsole(String givenInput) {
        if(givenInput == null || givenInput.isEmpty()) {
            System.out.println(this.calculateResult);
            return "결과 : " +this.calculateResult;
        }
        String outMessage =  "결과 : " + givenInput;
        System.out.println(outMessage);
        return outMessage;
    }
}