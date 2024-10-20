package calculator.service.adder;

import calculator.model.Global;
import java.math.BigDecimal;
import java.util.List;

public class DecAdder implements NumAdder {

    private final Global global;

    public DecAdder() {
        this.global = Global.getInstance();
    }

    @Override
    public void sum() {
        List<? extends Number> numbers = global.getNumList();
        BigDecimal result = BigDecimal.ZERO;
        for (Number i : numbers) {
            result = result.add((BigDecimal) i);
        }
        global.setResult(result);
    }
}
