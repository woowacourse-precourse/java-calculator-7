package calculator;

import java.util.Arrays;
import java.util.List;

public class DefaultStringSplitter implements StringSplitter{

    @Override
    public List<String> splitString (String str) {
        String[] split = str.split(DEFAULT_DELIMITER);
        return Arrays.asList(split);
    }
}
