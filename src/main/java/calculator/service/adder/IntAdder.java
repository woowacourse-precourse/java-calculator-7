package calculator.service.adder;

import calculator.model.Global;
import java.math.BigInteger;
import java.util.List;

public class IntAdder implements NumAdder {

    private final Global global;

    public IntAdder() {
        this.global = Global.getInstance();
    }

    @Override
    public void sum() {
        List<? extends Number> numbers = global.getNumList();
        BigInteger result = BigInteger.ZERO;
        for (Number i : numbers) {
            result = result.add((BigInteger) i);
        }
        global.setResult(result);
    }
}
