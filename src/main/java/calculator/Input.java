package calculator;

import java.util.ArrayList;

public record Input(String inputString) {
    public boolean isValid() {
        if (inputString.isEmpty() || inputString.matches("\\d+")) {
            return true;
        } else {
            if (inputString.matches("\\d+([,:]\\d+)*")) {
                return true;
            } else if (inputString.charAt(0) == '/') {
                ArrayList<String> customDelimiters = Delimiter.getCustomDelimiters(inputString);
                if (customDelimiters.isEmpty()) {
                    return false;
                } else {
                    StringBuilder delimiterPattern = new StringBuilder(",:");
                    for (String delimiter : customDelimiters) {
                        delimiterPattern.append(delimiter);
                    }
                    String regex = "(//(.)\\\\n)+\\d+([" + delimiterPattern + "]\\d+)*";
                    return inputString.matches(regex);
                }
            } else {
                return false;
            }
        }
    }

    private String[] splitStringByDelimiter() {
        StringBuilder inputPart = new StringBuilder(inputString);

        if (inputPart.isEmpty()) {
            return new String[]{"0"};
        }

        if (inputPart.charAt(0) == '/') {
            while (inputPart.charAt(0) == '/') {
                inputPart.delete(0, 5);
            }
        }

        ArrayList<String> delimiters = Delimiter.getCustomDelimiters(inputString);
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
