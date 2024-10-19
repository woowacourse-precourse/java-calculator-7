package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParsing {
    public static String[] Delimiter(String strInput) {
        String delimiter = ",|:"; // 기본 구분자
        strInput = strInput.replace("\\n", "\n");

        Matcher m = Pattern.compile("//(.*?)\\n(.*)", Pattern.DOTALL).matcher(strInput);
        if (m.find()) {
            String delimPart = m.group(1); // 커스텀 구분자 부분
            strInput = m.group(2);         // 숫자 부분

            delimiter += "|" + Pattern.quote(delimPart);
        }
        return strInput.split(delimiter);
    }
}


