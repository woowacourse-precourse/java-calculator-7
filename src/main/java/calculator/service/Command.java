package calculator.service;

import calculator.service.separator.Separator;

public record Command(Separator customSeparator, String expression) {

    public boolean hasCustomSeparator() {
        return customSeparator != null;
    }
}
