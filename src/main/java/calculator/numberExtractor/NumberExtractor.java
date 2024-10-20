package calculator.numberExtractor;


import calculator.dto.NumberDto;
import calculator.utils.ExceptionUtils;

public interface NumberExtractor {

    public NumberDto extractNumbers(String input, String delimiter);

    default Integer parseNumber(String split) {

        try {
            int parseInt = Integer.parseInt(split);
            return parseInt;
        } catch (NumberFormatException e) {
            ExceptionUtils.throwCanNotParseToNumberException();
        }
        return null;
    }
}
