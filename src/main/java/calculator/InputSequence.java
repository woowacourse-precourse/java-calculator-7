package calculator;

import java.util.Arrays;
import java.util.List;

public class InputSequence {

    private final List<Long> sequence;

    public InputSequence(String input) {
        this.sequence = Arrays.stream(input.split("[,:]"))
                            .map(Long::parseLong)
                            .toList();
    }
}
