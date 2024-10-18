package calculator.operator;

import calculator.arithmeticUnit.ArithmeticOperation;

import java.util.HashMap;

public class OperatorMap {
    private static final OperatorMap INSTANCE = new OperatorMap();
    private final HashMap<Separator, ArithmeticOperation> operatorMapBySeparator = new HashMap<>();

    private OperatorMap() {
    }

    public static OperatorMap getInstance() {
        return INSTANCE;
    }

    public void registerSeparatorToOperator(Separator separator, ArithmeticOperation operation) {
        operatorMapBySeparator.put(separator, operation);
    }

    public ArithmeticOperation getOperatorBySeparator(Separator separator) {
        return operatorMapBySeparator.get(separator);
    }
}
