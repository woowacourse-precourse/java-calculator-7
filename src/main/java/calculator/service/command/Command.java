package calculator.service.command;

import calculator.service.separator.Separator;

public record Command(Separator customSeparator, String expression) {

    public boolean hasCustomSeparator() {
        return customSeparator != null;
    }
}
