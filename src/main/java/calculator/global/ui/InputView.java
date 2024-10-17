package calculator.global.ui;

import javax.swing.text.NumberFormatter;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private String delimiter = "[,;]";

    private String checkCustomDelimiter(String input) {

        if (input.startsWith("//")) {

            if (!input.contains("\\n")) {
                throw new IllegalArgumentException();
            }
            delimiter = input.substring("//".length(), input.indexOf("\\n"));
        }
        return delimiter;
    }

    public String[] splitNumbers(String input) {
        delimiter = checkCustomDelimiter(input);

        if (!delimiter.equals("[,;]")) {
            input = input.substring(input.indexOf("\\n") + "\\n".length());
        }

        return input.split(delimiter);
    }

    public List<Integer> parseIntNumbers(String input) {
        String[] numbers = splitNumbers(input);
        List<Integer> numberList = new ArrayList<>();

        for (String number : numbers) {
            int i = numberVerify(number);
            numberList.add(i);
        }

        return numberList;
    }

    private int numberVerify(String number) {
        try {
            int i = Integer.parseInt(number);

            if (i < 0) {
                throw new IllegalArgumentException();
            }

            return i;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
