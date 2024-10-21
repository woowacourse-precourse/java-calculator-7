package calculator;

import static calculator.Constants.CUSTOM_END;
import static calculator.Constants.DELIMITERS;

public class Converter {
    static String removeCustomDelimiterAndSpace(String target, String delimiter) {
        if (!("").equals(delimiter)) {
            for (int i = 0; i < delimiter.length(); i++) {
                DELIMITERS.add(delimiter.charAt(i));
            }
        }
        int index = target.indexOf(CUSTOM_END) + CUSTOM_END.length();
        return target.substring(index).replaceAll(" ", "");
    }

    static String[] convertToArray(String target) {
        StringBuilder sb = new StringBuilder();
        for (Character del : DELIMITERS) {
            sb.append(del);
            sb.append('|');
        }
        sb.deleteCharAt(sb.length()-1);

        return target.split(sb.toString());
    }

}
