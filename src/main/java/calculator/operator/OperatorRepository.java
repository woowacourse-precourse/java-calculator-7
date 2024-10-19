package calculator.operator;

import java.util.HashMap;
import java.util.Map;

public class OperatorRepository {

    private Map<String, Operator> operators;

    public OperatorRepository() {
        this.operators = new HashMap<String, Operator>();
    }

    public Operator getOperator(String separator) {
        return operators.get(separator);
    }

    public void addOperator(String separator, Operator operator) {
        operators.put(separator, operator);
    }
}
