package calculator;

import static calculator.Constants.DELIMITERS;

public class Converter {
    static String removeCustomDelimiterAndSpace(String target, String delimiter) {
        if (!("").equals(delimiter)) {
            for (int i = 0; i < delimiter.length(); i++) {
                DELIMITERS.add(delimiter.charAt(i));
            }
        }

        int index = target.indexOf("\\n") + 2;
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
