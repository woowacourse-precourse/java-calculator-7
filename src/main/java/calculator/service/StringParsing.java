package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringParsing {

    public static String[] Delimiter(String strInput) {
        String delimiter = ",|:";
        strInput = strInput.replace("\\n", "\n");
        Matcher m = Pattern.compile("//(.*?)\\n(.*)").matcher(strInput);
        if (m.find()) {
            delimiter = delimiter + "|" + Pattern.quote(m.group(1));
            strInput = m.group(2);
        }
        return strInput.split(delimiter);
    }
}


