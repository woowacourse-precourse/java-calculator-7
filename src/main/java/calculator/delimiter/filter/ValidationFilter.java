package calculator.delimiter.filter;

public abstract class ValidationFilter {
    private ValidationFilter next;

    public static ValidationFilter link(ValidationFilter first, ValidationFilter... chain) {
        ValidationFilter head = first;
        for (ValidationFilter nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean validate(String str) throws IllegalStateException;

    protected boolean doFilter(String str) {
        if (next == null) {
            return true;
        }

        return next.validate(str);
    }
}
