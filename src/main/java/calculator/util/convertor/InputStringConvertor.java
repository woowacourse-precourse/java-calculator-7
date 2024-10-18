package calculator.util.convertor;

import java.util.Arrays;
import java.util.List;

public class InputStringConvertor implements StringConvertor<Integer> {

    @Override
    public List<Integer> convertToListWithDelimiter(final String str, final String delimiter) {
        final String[] tokens = str.split(delimiter);
        return Arrays.stream(tokens)
                .filter(token -> !token.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }
}
