package calculator;

public class Delimiter {

    public String checkDelimiter(String numbers) {
        String delimiter = ":|,";
        if (isCustomDelimiter(numbers)) {
            //f\n1f2f2
            /*String delimiter = numbers.substring(2);
            if (delimiterEndIndex != -1) {
                delimiter = numbers.substring(2,3);
                return delimiter;
            }*/
            delimiter = numbers.substring(2, 3);
            return delimiter;
        }
        return delimiter;
    }

    private boolean isCustomDelimiter(String numbers) {
        return numbers.startsWith("//");
    }
}
