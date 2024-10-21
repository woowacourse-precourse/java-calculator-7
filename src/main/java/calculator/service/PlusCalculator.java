package calculator.service;

import calculator.validation.CalculatorValidation;

import java.util.Arrays;
import java.util.List;

public class PlusCalculator implements CalculatorService {

    private static CalculatorService instance;

    private PlusCalculator() {
    }

    public static CalculatorService getInstance() {
        if (instance == null) {
            instance = new PlusCalculator();
        }
        return instance;
    }

    static CalculatorValidation validation = new CalculatorValidation();

    @Override
    public int operation(List<String> numList) {
        return numList.stream()
                .filter(num -> !num.isEmpty())
                .map(validation::validateParseInt)
                .peek(validation::validatePositiveNumber)
                .reduce(0, validation::validatePlusOverflow);
    }

    @Override
    public List<String> splitDigits(String numStr) {
        String[] arrs = numStr.split("\\\\n");

        String customArr = "";
        String digitsArr = "";

        if (arrs.length == 1) digitsArr = numStr;
        if (arrs.length == 2) {
            customArr = arrs[0];
            digitsArr = arrs[1];
        }

        return Arrays.stream(digitsArr.split(findCustomRex(customArr)))
                .filter(nums -> !nums.isEmpty())
                .toList();
    }

    public String findCustomRex(String customArr) {
        String rex = "[,:";
        String customRex = "";

        if (customArr.startsWith("//") && customArr.length() > 2) {
            customRex = customArr.substring(2);
        }

        if (!customRex.isEmpty()) rex += customRex;

        rex += "]";

        return rex;
    }

}
