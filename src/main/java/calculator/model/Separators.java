package calculator.model;

import static calculator.common.exception.ErrorMessage.SEPARATOR_DUPLICATION_ERROR;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record Separators(List<Separator> separators) {

    public static Separators from(List<Separator> separators) {
        return new Separators(Validator.validate(separators));
    }

    public Separators addSeparator(Separator separator) {
        List<Separator> updatedSeparators = new ArrayList<>(this.separators);
        updatedSeparators.add(separator);
        Validator.validate(updatedSeparators);
        return new Separators(updatedSeparators);
    }

    private static class Validator {
        private static List<Separator> validate(List<Separator> separators) {
            validateDuplication(separators);
            return separators;
        }

        private static void validateDuplication(List<Separator> separators) {
            int distinctValueCount = separators.stream()
                    .map(Separator::separator)
                    .collect(Collectors.toSet())
                    .size();

            if (distinctValueCount != separators.size()) {
                throw new IllegalArgumentException(SEPARATOR_DUPLICATION_ERROR);
            }
        }
    }
}
