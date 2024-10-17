package calculator;

public class MyCalculator {
    private String numString;

    public MyCalculator(String numString) {
        this.numString = numString;
    }

    private String customSeparator(String str) {
        if (str.startsWith("//") && str.contains("\n")) {
            return Character.toString(str.charAt(2));
        }
        return " ";
    }

    private String[] makeArray() {
        if (numString.contains(customSeparator(numString))) {
            numString = numString.substring(4);
            numString = numString.replace(customSeparator(numString), " ");
        }
        numString = numString.replace(",", " ");
        numString = numString.replace(":", " ");

        String[] numArray = numString.split(" ");

        return numArray;
    }
}
