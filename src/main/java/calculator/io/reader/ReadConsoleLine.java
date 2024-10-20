package calculator.io.reader;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ReadConsoleLine implements Input {
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

        if (input.startsWith("//") && input.contains("\\n")) {
            separtor = input.substring(input.indexOf("//") + 2, input.indexOf("\\n"));
            if (separtor.length() != 1)
                throw new IllegalArgumentException("Separator format is invalid");
            else
                numberPart = input.substring(input.indexOf("\\n") + 2);
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

    @Override
    public List<String> extractSeparator(String input) {
        if (input.startsWith("//"))
            return List.of(",", ":", input.substring(2, 3));
        else
            return List.of(",", ":");
    }
}
