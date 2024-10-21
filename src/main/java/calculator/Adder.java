package calculator;

public class Adder {

    private static final String DEFAULT_DELIM = "[,:]";
    private static final String CUSTOM_DELIM_PREFIX = "//";
    private static final String CUSTOM_DELIM_SUFFIX = "\n";

    public int run(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (input.startsWith(CUSTOM_DELIM_PREFIX) && input.contains(CUSTOM_DELIM_SUFFIX)) {
            String[] split = input.split(CUSTOM_DELIM_SUFFIX);
            String customDelimiter = split[0].substring(CUSTOM_DELIM_PREFIX.length());

            return run(split[1], customDelimiter);
        }
        return run(input, DEFAULT_DELIM);
    }

    private int run(String input, String delim) {
        String[] stringNumbers = input.split(delim);
        int sum = 0;

        for (String stringNumber : stringNumbers) {
            int number = Integer.parseInt(stringNumber);
            if (number <= 0) {
                throw new IllegalArgumentException("전달된 숫자는 0보다 작거나 같을 수 없습니다.");
            }
            sum += number;
        }
        return sum;
    }
}
