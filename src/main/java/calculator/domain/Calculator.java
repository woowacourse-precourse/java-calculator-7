package calculator.domain;

import java.util.List;

public class Calculator {

    private final Decoder decoder;

    public Calculator(Decoder decoder) {
        this.decoder = decoder;
    }

    public int addAll() {
        int result = 0;
        List<Integer> numbers = decoder.getDecodedNumbers();
        for (int n : numbers) {
            result += n;
        }
        return result;
    }
}
