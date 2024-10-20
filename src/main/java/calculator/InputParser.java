package calculator;

import java.util.ArrayList;

public class InputParser {

    final static String basicSeparators = ":,";
    static String regex = "[:,]";

    public static ArrayList<Integer> parse() {
        String inputData = InputHandler.getInputData();

        ArrayList<Integer> numbers = new ArrayList<>();

        String[] values = inputData.split(regex);

        for (String i : values) {
            numbers.add(Integer.parseInt(i));
        }

        return numbers;
    }

}
