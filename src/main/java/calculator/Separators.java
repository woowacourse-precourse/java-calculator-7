package calculator;

import static calculator.constants.DesignSeparator.END;
import static calculator.constants.DesignSeparator.START;
import static calculator.constants.ExceptionCode.NULL_INPUT;
import static calculator.constants.ExceptionCode.VAILDATION_CUSTOME;

import calculator.constants.BasicSeparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separators {

    private List<String> separators;

    public Separators() {
        this.separators = new ArrayList<>(
                Arrays.asList(BasicSeparator.COMMA.getSymbol(), BasicSeparator.COLON.getSymbol()));
    }

    public List<String> getSeparators() {
        return separators;
    }

    public String containCustomSeparator(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_INPUT.getMessage());
        }
        if (input.startsWith(START.getSymbol()) && input.contains(END.getSymbol())) {
            int customSeparatorStartIdx = START.getSymbolLength();
            int customSeparatorEndIdx = input.indexOf(END.getSymbol());

            if (customSeparatorEndIdx == -1) {
                throw new IllegalArgumentException(VAILDATION_CUSTOME.getMessage());
            }

            if (customSeparatorStartIdx + 1 != customSeparatorEndIdx) {
                throw new IllegalArgumentException(VAILDATION_CUSTOME.getMessage());
            }

            separators.add(input.substring(customSeparatorStartIdx, customSeparatorEndIdx));
            this.separators = List.copyOf(separators);
            return input.substring(customSeparatorEndIdx + END.getSymbolLength());
        }
        return input;
    }

    public String getRegex() {
        return String.join("|", separators);
    }
}
