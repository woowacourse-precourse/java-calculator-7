package calculator.Add;

import java.math.BigInteger;
import java.util.ArrayList;

public class AddServiceImpl implements AddService {
    private BigInteger addResult = new BigInteger("0");
    @Override
    public void add(ArrayList<BigInteger> numbers) {
        for (BigInteger number : numbers) {
            addResult=addResult.add(number);
        }
    }
    @Override
    public BigInteger getAddResult() {
        return addResult;
    }
}
