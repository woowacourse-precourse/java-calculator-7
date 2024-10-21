package calculator.domain.model;

import calculator.domain.model.value.MajorData;
import calculator.domain.model.value.PositiveNumber;
import calculator.domain.model.value.Separator;

import java.util.Arrays;
import java.util.List;

import static calculator.global.ErrorConst.INVALID_NUMBER;

public class Translator {

    private Separator separator;

    public Translator(Separator separator) {
        this.separator = separator;
    }

    public List<PositiveNumber> translate(final MajorData majorData) {
        try {
            return translateToPositiveNumbers(majorData);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    private List<PositiveNumber> translateToPositiveNumbers(MajorData majorData) {
        String[] splitData = majorData.split(separator);

        return Arrays.stream(splitData)
                .map(Long::parseLong)
                .map(PositiveNumber::new)
                .toList();
    }
}
