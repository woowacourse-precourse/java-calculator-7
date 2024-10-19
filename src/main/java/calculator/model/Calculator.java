package calculator.model;

import java.util.List;

public class Calculator {

    private final Operator operator;

    public Calculator(){
        this.operator = new AddOperator();
    }

    public int add(List<Integer> numberList){
        return operator.operate(numberList);
    }
}
