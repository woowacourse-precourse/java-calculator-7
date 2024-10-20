package calculator.io.reader;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ReadConsoleLine implements Input {

    private static final String SEPARATOR_PREFIX = "//";
    private static final String SEPARATOR_SUFFIX = "\\n";

    @Override
    public String inputString() {
        System.out.println("Please enter the strings to add.");
        return Console.readLine();
    }

    @Override
    public String validateInput(String input) {
        if (input.isBlank())
            return "";

        String numberPart = input;
        String separtor = "";

        if (input.startsWith(SEPARATOR_PREFIX) && input.contains(SEPARATOR_SUFFIX)) {
            separtor = input.substring(input.indexOf(SEPARATOR_PREFIX) + 2, input.indexOf(SEPARATOR_SUFFIX));
            if (separtor.length() != 1)
                throw new IllegalArgumentException("Separator format is invalid");
            else
                numberPart = input.substring(input.indexOf(SEPARATOR_SUFFIX) + 2);
        }

        List<String> separators = new java.util.ArrayList<>(List.of(",", ":"));
        if(!separtor.isEmpty()) separators.add(separtor);

        for (int i = 0; i < numberPart.length(); i++) {
            if (!separators.contains(String.valueOf(numberPart.charAt(i)))
                    && !Character.isDigit(numberPart.charAt(i)))
                throw new IllegalArgumentException("Number part is invalid");
        }

        return numberPart;
    }
}
