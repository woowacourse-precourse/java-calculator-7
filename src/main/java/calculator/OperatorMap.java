package calculator;

import java.util.HashMap;

public class OperatorMap {
    private static final OperatorMap INSTANCE = new OperatorMap();
    private final HashMap<Separator, OperatorEnum> operatorMapBySeparator = new HashMap<>();

    private OperatorMap() {
    }

    public static OperatorMap getInstance() {
        return INSTANCE;
    }

    public void registerSeparatorToOperator(Separator separator, OperatorEnum operator) {
        operatorMapBySeparator.put(separator, operator);
    }

    public OperatorEnum getOperatorBySeparator(Separator separator) {
        return operatorMapBySeparator.get(separator);
    }
}
