package calculator.domain;

public class Calculator {

    private final Decoder decoder;

    public Calculator(Decoder decoder) {
        this.decoder = decoder;
    }

    public int addAll() {
        int result = 0;
        for(int n : decoder.getDecodedNumbers()) {
            result+=n;
        }
        return result;
    }
}
