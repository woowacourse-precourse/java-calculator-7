package calculator.numberExtractor;


import calculator.dto.NumberDto;
import calculator.utils.ExceptionUtils;

public interface NumberExtractor {

    public NumberDto extractNumbers(String input, String delimiter);

    default Long parseNumber(String split) {

        try {
            long parseInt = Long.parseLong(split);
            return parseInt;
        } catch (NumberFormatException e) {
            ExceptionUtils.throwCanNotParseToNumberException();
        }
        return null;
    }
}
