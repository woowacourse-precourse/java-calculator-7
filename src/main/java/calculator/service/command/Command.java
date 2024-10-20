package calculator.service.command;

import calculator.service.expression.Expression;
import calculator.service.separator.Separator;

public record Command(Separator customSeparator, Expression expression) {

    public boolean hasCustomSeparator() {
        return customSeparator != null;
    }
}
