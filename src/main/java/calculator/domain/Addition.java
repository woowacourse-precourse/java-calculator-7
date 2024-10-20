package calculator.domain;

public class Addition implements Operation{

    private static final Operation instance = new Addition();

    private Addition() { }

    public static Operation getInstance() {
        return instance;
    }

    @Override
    public Number execute(Number a, Number b) throws IllegalArgumentException {
        return new Number(addWithOverflowCheck(a.getValue(), b.getValue()));
    }

    private int addWithOverflowCheck(int a, int b) throws IllegalArgumentException {
        if (a > 0 && b > 0 && a > Integer.MAX_VALUE - b) {
            throw new IllegalArgumentException("덧셈 중 오버플로우가 발생했습니다.");
        }
        if (a < 0 && b < 0 && a < Integer.MIN_VALUE - b) {
            throw new IllegalArgumentException("덧셈 중 오버플로우가 발생했습니다.");
        }
        return a + b;
    }
}
