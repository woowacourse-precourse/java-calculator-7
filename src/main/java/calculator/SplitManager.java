package calculator;

import java.util.regex.Pattern;

public class SplitManager {
    public String[] splitString(Input input) {
        String str = input.getStr().trim();
        String splitter = input.getSplitter();

        return splitter.equals("[,:]") ? str.split("[,:]") : str.split(Pattern.quote(splitter));
    }
}
