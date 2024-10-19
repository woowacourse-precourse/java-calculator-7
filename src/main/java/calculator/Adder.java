package calculator;

import java.util.*;

public class Adder { //TODO: 싱글톤을 고려해볼 것

    private final Set<String> delimiters;
    private final List<String> operands;


    public Adder(List<String> operands) {
        this(Set.of(), operands);
    }

    public Adder(Set<String> delimiters, List<String> operands) {
        this.delimiters = new HashSet<>(Set.of(",", ":"));
        this.delimiters.addAll(delimiters);

        this.operands = new ArrayList<>(operands);
    }

    public int sum() {
        int sum = 0;

        for (String operand : operands) {
            sum += Integer.parseInt(operand);
        }
        return sum;
    }


}
