package calculator;

public class NumberExtractor {

    public static int[] getDigits(String userInput) {

        if(userInput.startsWith("//")) {
            int customSeparatorEndIndex = userInput.indexOf("\\n");
            char customSeparator = userInput.charAt(2);
            String trimmedInput = userInput.substring(customSeparatorEndIndex + 2).trim();
            String[] numbersStrings = trimmedInput.split("[,:" + customSeparator + "]");
            int[] numbersInt = new int[numbersStrings.length];
            for (int i = 0; i < numbersStrings.length; i++) {
                numbersInt[i] = Integer.parseInt(numbersStrings[i].trim());
            }
            return numbersInt;
        } else {
            String[] numbersStrings = userInput.split("[,:]");
            int[] numbersInt = new int[numbersStrings.length];
            for (int i = 0; i < numbersStrings.length; i++) {
                numbersInt[i] = Integer.parseInt(numbersStrings[i].trim());
            }
            return numbersInt;
        }
    }
}