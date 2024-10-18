package calculator.model;

import java.util.List;

public class Numbers {
    private List<Number> values;

    Numbers(List<Number> values){
        this.values = values;
    }

    public List<Number> getNumbersValue() {
        return values;
    }
}
