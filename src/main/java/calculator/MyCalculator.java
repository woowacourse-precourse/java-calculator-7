package calculator;

public class MyCalculator {
    private String numString;
    private String[] delimiters = {",", ":", "`", "~", "!", "@", "#", "$", "%", "^", "&", "*", ";", ".", "/", "-", "=",
            "_", "+"};

    private String findDelimiter(String str) {
        String delimiter = "";
        for (int i = 0; i < delimiters.length; i++) {
            if (!str.matches("//(s)\n(.*)")) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
            }
            delimiter = delimiters[i];
        }
        return delimiter;
    }

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

    public int getSum() {
        if (numString.equals("")) {
            return 0;
        }
        String[] array = makeArray();
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += Integer.parseInt(array[i]);
        }

        return sum;
    }
}
