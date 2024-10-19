package calculator.service;

public record Command(Separator customSeparator, String expression) {

    public boolean hasCustomSeparator() {
        return customSeparator != null;
    }
}
