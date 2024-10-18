package calculator.service.convertor;

import calculator.model.Global;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntConverter implements NumConverter {

    private final Global global;
    private List<BigInteger> numbers;

    public IntConverter() {
        this.global = Global.getInstance();
        numbers = new ArrayList<>();
    }

    @Override
    public void convertNumber() {
        String[] target = global.getStrNums();
        Arrays.stream(target).forEach(i -> {
            validateNumberRange(i);
            BigInteger element = (BigInteger) convertNumberElement(i);
            numbers.add(element);
        });
        global.setNumList(numbers);
    }

    @Override
    public Number convertNumberElement(String numStrElement) {
        try {
            return new BigInteger(numStrElement);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void validateNumberRange(String numStr) {
        if (numStr.startsWith("-")) {
            throw new IllegalArgumentException();
        }
    }
}
