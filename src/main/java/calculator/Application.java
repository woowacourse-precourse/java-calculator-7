package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Input.inputString();
        String numberPart = Input.validateInput(input);
    }
}

class Input {
    public static String inputString() {
        System.out.println("Please enter the strings to add.");
        return Console.readLine();
    }

    public static String validateInput(String input) {
        if(input.isBlank())
            throw new IllegalArgumentException("Blank InputString Error");

        if(input.startsWith("//") && input.contains("\\n")) {
            String delimiterSection = input.substring(2, input.indexOf("\\n"));
            if(delimiterSection.length() == 1)
                return input.substring(input.indexOf("\\n") + 2);
            else
                throw new IllegalArgumentException("Separator format is invalid");
        }
        else if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
            return input;
        }
        else
            throw new IllegalArgumentException("Invalid InputString Error");
    }
}
