package calculator;

public class Calculator {
    public int add(String input) {

        //공백인 경우 0을 반환함
        if (input.isEmpty()) {
            return 0;
        }

        if (input.startsWith("//")) {
            String[] customResult = customDelimeter(input);
            String newDelimiter = customResult[0];
            input = customResult[1];
        }


    }

    public String[] customDelimeter(String input) {

    }
}
