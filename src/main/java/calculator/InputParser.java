package calculator;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    List<String> separators;
    String regex;
    InputHandler inputHandler;

    public InputParser() {
        this.inputHandler = InputHandler.getInstance();
        separators = new ArrayList<>();
        separators.add(":");
        separators.add(",");
    }

    public void buildRegex() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(concatSeparactor());
        sb.append("]");
        regex = sb.toString();
    }

    public String concatSeparactor() {
        StringBuilder sb = new StringBuilder();
        for (String separator : separators) {
            sb.append(separator);
        }
        return sb.toString();
    }

    public void addSeparactor(String customSeparator) {
        separators.add(customSeparator);
    }


    public String removeCustomSeparactor(String data) {
        StringBuilder sb = new StringBuilder(data);
        int endIndex = sb.indexOf("n");
        String dataWithoutCustomSeparator = sb.delete(0, endIndex + 1).toString();
        inputHandler.setInputData(dataWithoutCustomSeparator);
        return dataWithoutCustomSeparator;
    }

    public String parseCustomSeparator(String data) {
        StringBuilder sb = new StringBuilder(data);
        int endIndex = sb.indexOf("\\");
        String customSeparator = sb.substring(2, endIndex);
        return customSeparator;
    }

    public List<Integer> parse() {
        String data = inputHandler.getInputData();

        List<Integer> numbers = new ArrayList<>();

        if (data.isEmpty()) {
            numbers.add(0);
        } else {
            buildRegex();

            String[] values = data.split(regex);

            for (String i : values) {
                numbers.add(Integer.parseInt(i));
            }
        }

        return numbers;
    }

}
