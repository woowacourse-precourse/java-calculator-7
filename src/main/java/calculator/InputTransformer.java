package calculator;

public class InputTransformer {
    private int[] transDefaultDelimiter(String userInput){
        String[] stringArray = userInput.split("[:,]");
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++){
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    private int[] transCustomDelimiter(String userInput){
        return new int[0];
    }

    public int[] stringToIntArray(String userInput, DelimiterType delimiterType){
        if (delimiterType == DelimiterType.EMPTY) return new int[0];
        if (delimiterType == DelimiterType.DEFAULT) return transDefaultDelimiter(userInput);
        if (delimiterType == DelimiterType.CUSTOM) return transCustomDelimiter(userInput);
        return null;
    }
}
