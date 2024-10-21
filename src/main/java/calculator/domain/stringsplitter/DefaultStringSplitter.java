package calculator.domain.stringsplitter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultStringSplitter implements StringSplitter {

    @Override
    public boolean canSupport(String str) {
        Pattern pattern = Pattern.compile("^[0-9]+([" + DEFAULT_DELIMITER + "][0-9]+)*$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    @Override
    public List<String> splitString(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, DEFAULT_DELIMITER);
        List<String> strings = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            strings.add(stringTokenizer.nextToken());
        }
        return strings;
    }
}
