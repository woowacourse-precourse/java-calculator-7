package calculator.model.expression;

import java.util.List;

public interface Expression {

    String getInput();

    String getDelimiter();

    List<String> getOperands();
}
