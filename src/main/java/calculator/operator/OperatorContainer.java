package calculator.operator;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class OperatorContainer {
    private final List<Operator> operators;
    private final Map<Separator, Operator> operatorMapBySeparator;

    public OperatorContainer(List<Operator> operators) {
        this.operators = new ArrayList<>(operators);
        this.operatorMapBySeparator = initMap(operators);
    }

    private Map<Separator, Operator> initMap(List<Operator> operators) {
        Map<Separator, Operator> operatorMap = new HashMap<>();
        operators.forEach(operator -> operatorMap.put(operator.getSeparator(), operator));
        return operatorMap;
    }

    public Operator getOperator(Separator target) {
        return operatorMapBySeparator.get(target);
    }

    public void add(Operator operator) {
        operators.add(operator);
        operatorMapBySeparator.put(operator.getSeparator(), operator);
    }

    public List<String> getSymbols() {
        return operators.stream()
                .map(Operator::getSymbol)
                .toList();
    }
}
