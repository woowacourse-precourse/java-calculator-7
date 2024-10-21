package calculator.parser;

import calculator.model.CalculatorModel;
import java.util.Set;

public interface SeparatorParser {

    public void parse(CalculatorModel model);

    public String getVALID_CUSTOM_SEPARATOR_PATTERN();

    public Set getSeparators();
}
