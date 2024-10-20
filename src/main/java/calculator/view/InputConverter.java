package calculator.view;

import java.util.List;

public class InputConverter {

    private char delimiter = ' ';

    public List<Integer> convert(String input) {
        if (input.indexOf("//") == 0) {
            int afterIndex = input.indexOf("\\n");
            delimiter = input.substring(2, afterIndex).charAt(0);
            input = input.substring(afterIndex+2);
        }

        List<Integer> list;
        try {
            list = input.chars()
                    .mapToObj(i -> (char) i)
                    .filter(i -> i != ',')
                    .filter(i -> i != ':')
                    .filter(i -> i != delimiter)
                    .map(i -> Integer.parseInt(String.valueOf(i)))
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        return list;
    }

}
