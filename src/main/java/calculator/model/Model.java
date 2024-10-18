package calculator.model;

import calculator.exception.Exception;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

    private final List<String> delimiter = new ArrayList<>();
    private int sum = 0;

    public Model() {
        delimiter.add(",");
        delimiter.add(":");
    }

    public int result(String input) {
        if(input.isEmpty()) return 0;
        String numString = isCustom(input);
        addNumbers(numString);
        return sum;
    }

    public String isCustom(String input) {
        if(input.startsWith("//")) {
            isValidCustom(input);
            int stringIndex = input.indexOf("\\n");
            String customDelimiter = input.substring(2, stringIndex);
            delimiter.add(customDelimiter);
            String addCustomInput = input.substring(stringIndex + 2);
            return addCustomInput;
        }
        return input;
    }

    public void isValidCustom(String input) {
        if(!input.contains("\\n")) {
            Exception.exceptionInputPattern();
        }
    }

    public void addNumbers(String numString) {
        for(String deli : delimiter) {
            numString = numString.replace(deli, ",");
        }
        String[] numbers = numString.split(",");
        for(String num : numbers) {
            int n = isValidInteger(num);
            isOverZero(n);
            sum += n;
        }
    }

    public int isValidInteger(String num) {
        int n = 0;
        try {
            n = Integer.parseInt(num);
        } catch (IllegalArgumentException e) {
            Exception.exceptionInputPattern();
        }
        return n;
    }

    public void isOverZero(int n) {
        if(n < 0) Exception.exceptionInputPattern();
    }

}
