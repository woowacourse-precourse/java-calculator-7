package calculator;

public class Calculator {

    public int getTotal(String[] numberStrings) {
        int total = 0;
        for(String strNumber: numberStrings) {

            int parsedNumber = parseNumber(strNumber);

            checkPositiveNumber(parsedNumber);

            total += parsedNumber;
        }
        return total;
    }


    public int parseNumber(String stringNumber) {
        int intNumber;
        try {
            intNumber = Integer.parseInt(stringNumber);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Exception> 숫자가 아닌 값 입력: " + stringNumber);
        }
        return intNumber;
    }


    public void checkPositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Exception> 음수 입력" + number);
        }
    }
}
