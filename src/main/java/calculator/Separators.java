package calculator;

import calculator.constants.BasicSeparator;
import calculator.constants.DesignSeparator;
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
            throw new IllegalArgumentException("입력값이 null이 될 수 없습니다.");
        }
        if (input.startsWith(DesignSeparator.START.getSymbol()) && input.contains(
                DesignSeparator.END.getSymbol())) {
            int customSeparatorStartIdx = DesignSeparator.START.getSymbolLength();
            int customSeparatorEndIdx = input.indexOf(DesignSeparator.END.getSymbol());

            if (customSeparatorEndIdx == -1) {
                throw new IllegalArgumentException("커스텀 구분자가 올바르게 입력되지 않았습니다.");
            }

            if (customSeparatorStartIdx + 1 != customSeparatorEndIdx) {
                throw new IllegalArgumentException("커스텀 구분자가 올바르게 입력되지 않았습니다.");
            }

            separators.add(input.substring(customSeparatorStartIdx, customSeparatorEndIdx));
            this.separators = List.copyOf(separators);
            return input.substring(customSeparatorEndIdx + DesignSeparator.END.getSymbolLength());
        }
        return input;
    }

    public String getRegex() {
        return String.join("|", separators);
    }
}
