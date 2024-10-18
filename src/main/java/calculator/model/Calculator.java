package calculator.model;

import java.math.BigInteger;
import java.util.ArrayList;

public class Calculator {

    private final ArrayList<String> addEntries;

    public Calculator() {
        this.addEntries = new ArrayList<>();
    }

    public void setAddEntry(String addEntry) {
        addEntries.add(addEntry);
    }

    public BigInteger add(String input) {
        setAddEntry(input);
        return calculateSum(addEntries);
    }

    private BigInteger calculateSum(ArrayList<String> input) {
        BigInteger total = BigInteger.ZERO;

        for (String number : input) {
            total = total.add(new BigInteger(number));
        }
        return total;
    }

    public BigInteger getResult() {
        return calculateSum(addEntries);
    }

}
