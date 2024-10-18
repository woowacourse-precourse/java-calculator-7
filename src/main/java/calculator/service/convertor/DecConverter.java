package calculator.service.convertor;

import calculator.model.Global;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecConverter implements NumConverter {

    private final Global global;
    private List<BigDecimal> numbers;

    public DecConverter() {
        global = Global.getInstance();
        numbers = new ArrayList<>();
    }

    @Override
    public void convertNumber() {
        String[] target = global.getStrNums();
        Arrays.stream(target).forEach(i -> {
            validateNumberRange(i);
            BigDecimal element = (BigDecimal) convertNumberElement(i);
            numbers.add(element);
        });
        global.setNumList(numbers);
    }

    @Override
    public void validateNumberRange(String numStr) {
        if (numStr.startsWith("-")) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Number convertNumberElement(String numStrElement) {
        try {
            return new BigDecimal(numStrElement);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


}
