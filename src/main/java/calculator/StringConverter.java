package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringConverter {
    private NumberValidator numberValidator;
    public StringConverter(NumberValidator numberValidator) {
        this.numberValidator = numberValidator;
    }

    public List<Integer> toNumbers(List<String> stringInputs) {
        List<Integer> numberInputs = new ArrayList<>();
        numberValidator.validate(stringInputs);
        for(String s : stringInputs) {
            numberInputs.add(Integer.parseInt(s));
        }
        return numberInputs;
    }
}
