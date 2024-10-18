package calculator.delimiter.filter;

public class NegativeNumberValidationFilter extends ValidationFilter {
    @Override
    public boolean validate(String str) throws IllegalArgumentException {
        if (str.matches(".*-\\d+.*")) {
            throw new IllegalArgumentException("음수가 포함되어 있습니다.");
        }
        return doFilter(str);
    }
}
