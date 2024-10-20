package calculator.utils;

import calculator.domain.Calculator;

public class Utils {

    public void addCustomDelimiters(Calculator calculator, String inputString) {
        if (inputString.startsWith("//")) {
            char[] delimiterChars = extractDelimitersFromHeader(inputString);
            for (char delimiter : delimiterChars) {
                calculator.delimiters.add(delimiter);
            }
        }
    }

    private char[] extractDelimitersFromHeader(String inputString) {
        String delimiterString = inputString.substring(2);
        String[] sections = delimiterString.split("\\\\n");
        return sections[0].toCharArray();
    }

    public String extractCalculationString(String inputString) {
        String[] sections = inputString.split("\\\\n");
        return sections[1];
    }

    public int[] convertStringToIntList(Calculator calculator, String inputString) {
        String result = calculator.getDelimitersAsString();
        String[] sections = inputString.split(result);

        int[] numbers = new int[sections.length];
        for (int i = 0; i < sections.length; i++) {
            numbers[i] = Integer.parseInt(sections[i]);
        }
        return numbers;
    }

    public int sumIntList(int[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }
}
