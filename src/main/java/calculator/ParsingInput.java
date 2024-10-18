package calculator;

public class ParsingInput {

    private static String[] splitAsToken(String input, String token){
        if (token.equals("[,:]")) {
            return input.split(token);
        }
        return input.substring(input.indexOf("\\n")+2).split(token);
    }

    private static int[] parseIntArray(String[] inputArray) {
        int[] parsedValueArray = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            int parsedValue = Integer.parseInt(inputArray[i]);
            if (parsedValue <= 0) {
                throw new IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.");
            }
            parsedValueArray[i] = parsedValue;
        }
        return parsedValueArray;
    }
}
