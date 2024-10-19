package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultStringSplitter implements StringSplitter{

    @Override
    public List<String> splitString (String str) {
        String[] split = str.split(DEFAULT_DELIMITERS);
        return Arrays.asList(split);
    }
}
