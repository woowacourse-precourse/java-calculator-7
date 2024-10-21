package calculator.number;

public class IntegerCalculator implements Calculator<Integer> {
    public static final int MAX_INT_LENGTH = 9;
    public static final String TOTAL_OVER_RANGE = "숫자의 합이 너무 큽니다.";
    public static final String RANGE_IS_NINE = "9자리 이하의 수를 입력하세요.";

    private Integer total = 0;
    private final StringBuilder sb = new StringBuilder("");

    @Override
    public void temporarySave(Character number) {
        validateRange(number);
        sb.append(number);
    }

    @Override
    public void save() {
        if (sb.length() != 0) {
            if (total > Integer.MAX_VALUE - Integer.parseInt(sb.toString())) {
                throw new IllegalArgumentException(TOTAL_OVER_RANGE);
            }
            total += Integer.parseInt(sb.toString());
            sb.setLength(0);
        }
    }

    @Override
    public void validateRange(Character number) {
        if (sb.length() + 1 > MAX_INT_LENGTH) {
            throw new IllegalArgumentException(RANGE_IS_NINE);
        }
    }

    @Override
    public Integer getTotal() {
        save();
        return total;
    }
}
