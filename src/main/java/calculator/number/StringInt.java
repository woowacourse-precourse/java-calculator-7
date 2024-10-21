package calculator.number;

public class StringInt implements StringNumber<Integer> {
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
            try {
                total += Integer.parseInt(sb.toString());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(TOTAL_OVER_RANGE);
            }
            sb.delete(0, sb.length());
        }
    }

    @Override
    public void validateRange(Character number) {
        if (sb.length() + 1 > MAX_INT_LENGTH) {
            throw new IllegalArgumentException(RANGE_IS_NINE);
        }
    }

    @Override
    public Integer getNumber() {
        return total;
    }
}
