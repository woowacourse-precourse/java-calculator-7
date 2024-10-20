package calculator;

import java.util.ArrayList;

public class InputParser {

    final static String basicSeparators = ":,";
    static String regex = "[:,]";

    public static void buildRegex(String customSeparator) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(basicSeparators);
        sb.append(customSeparator);
        sb.append("]");
        regex = sb.toString();
    }


    public static String customParse(String data) {
        StringBuilder sb = new StringBuilder(data);
        int endIndex = sb.indexOf("n");
        String customData = sb.delete(0, endIndex + 1).toString();
        return customData;
    }

    public static String parseSeparator(String data) {
        StringBuilder sb = new StringBuilder(data);
        int endIndex = sb.indexOf("\\");
        String customSeparator = sb.substring(2, endIndex);
        buildRegex(customSeparator);
        return customSeparator;
    }

    public static ArrayList<Integer> parse() {
        String inputData = InputHandler.getInputData();

        ArrayList<Integer> numbers = new ArrayList<>();

        if (inputData.isEmpty()) {
            numbers.add(0);
        } else {
            String[] values = inputData.split(regex);

            for (String i : values) {
                numbers.add(Integer.parseInt(i));
            }
        }

        return numbers;
    }

}
