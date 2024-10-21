package calculator;

public class ArrayBuilder {

    public String getStrNumbers(String numbers, int delimiterEndIndex) {
        if (delimiterEndIndex != 0){
            return numbers.substring(delimiterEndIndex + 2);
        }
        return numbers;
    }

    public String[] getSplitNumbers(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }
}
