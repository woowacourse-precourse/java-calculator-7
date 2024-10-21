package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class InputHandler {
    private String inputText;
    private String separators = ",;";

    private String positiveText;

    private void read() {
        inputText = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            inputText = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(new IllegalArgumentException().getMessage());
        }
    }

    private boolean haveCustomSeparator(String text) {
        return Pattern.matches("^//.*\\\\n.*$", text);
    }

    private void addCustomSeparator(String separatorText) {
        separatorText = separatorText.substring(2);
        for (char separator : separatorText.toCharArray()) {
            separators = separators + separator;
        }
    }

    private void splitInputText() {
        positiveText = inputText;
        if (haveCustomSeparator(inputText)) {
            String[] splitText = inputText.split("\\\\n");
            addCustomSeparator(splitText[0]);
            positiveText = splitText[1];
        }
    }

    private void checkPositiveNumber(double number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }

    private double parsePositiveNumber(String parseString) {
        try {
            double number = Double.parseDouble(parseString);
            checkPositiveNumber(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("주어진 문자열이 구분자와 양수로 이루어져 있지 않습니다.");
        }
    }

    public ArrayList<Double> generatePositiveList() {
        ArrayList<Double> positiveList = new ArrayList<>();
        read();
        splitInputText();
        String[] splitPositiveText = positiveText.split(separators);
        for (String positiveNumber : splitPositiveText) {
            positiveList.add(parsePositiveNumber(positiveNumber));
        }
        return positiveList;

    }

}
