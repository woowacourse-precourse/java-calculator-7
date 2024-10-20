package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class DefaultStringSplitter implements StringSplitter{

    @Override
    public List<String> splitString (String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, DEFAULT_DELIMITER);
        List<String> strings = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            strings.add(stringTokenizer.nextToken());
        };
        return strings;
    }
}
