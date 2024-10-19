package calculator;

import java.util.ArrayList;

public class Input {
    private final String input;

    public Input() {
        this.input = readInput();
    }

    private String readInput() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }


    public String getInput() {
        return input;
    }

    public boolean isValid() {
        if (input.isEmpty() || input.matches("\\d+")) {
            return true;
        } else {
            if (input.matches("\\d+([,:]\\d+)*")) {
                return true;
            } else if (input.charAt(0) == '/') {
                ArrayList<String> customDelimiters = Delimiter.getCustomDelimiters(input);
                if (customDelimiters.isEmpty()) {
                    return false;
                } else {
                    StringBuilder delimiterPattern = new StringBuilder(",:");
                    for (String delimiter : customDelimiters) {
                        delimiterPattern.append(delimiter);
                    }
                    String regex = "(//(.)\\\\n)+\\d+([" + delimiterPattern + "]\\d+)*";
                    return input.matches(regex);
                }

            } else {
                return false;
            }
        }
    }

    private String[] splitStringByDelimiter() {
        StringBuilder inputPart = new StringBuilder(input);

        if (inputPart.isEmpty()) {
            return new String[]{"0"};
        }
        if (inputPart.charAt(0) == '/') {
            while (inputPart.charAt(0) == '/') {
                inputPart.delete(0, 5);
            }
        }

        ArrayList<String> delimiters = Delimiter.getCustomDelimiters(input);
        delimiters.add(",");
        delimiters.add(":");

        String regex = String.join("|", delimiters);

        return new String(inputPart).split(regex);
    }

    public int[] getNumbersFromInput() {
        String[] stringArr = this.splitStringByDelimiter();
        int[] numArr = new int[stringArr.length];

        for (int i = 0; i < stringArr.length; i++) {
            numArr[i] = Integer.parseInt(stringArr[i].trim());
        }

        return numArr;
    }

}
