package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputTransformer {
    private int[] transDefaultDelimiter(String userInput) {
        String[] stringArray = userInput.split("[:,]");
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    private int[] transCustomDelimiter(String userInput) {
        String regex = "^//(.*?)\\\\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        boolean a = matcher.find();

        String delimiter = matcher.group(1);
        int prefixLength = matcher.group().length();
        String[] stringArray = userInput.substring(prefixLength).split(delimiter);
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].isEmpty()) {
                intArray[i] = 0;
            } else {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }
        }

        return intArray;
    }

    public int[] stringToIntArray(String userInput, DelimiterType delimiterType) {
        if (delimiterType == DelimiterType.EMPTY) return new int[]{};
        if (delimiterType == DelimiterType.DEFAULT) return transDefaultDelimiter(userInput);
        if (delimiterType == DelimiterType.CUSTOM) return transCustomDelimiter(userInput);
        return null;
    }
}
