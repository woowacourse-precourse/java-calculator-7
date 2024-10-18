package calculator.domain;

public class Numbers {

    public int[] parseToIntArray(String[] strNumbers) {
        int[] intNumbers = new int[strNumbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            intNumbers[i] = Integer.parseInt(strNumbers[i]);
        }

        return intNumbers;
    }

}
