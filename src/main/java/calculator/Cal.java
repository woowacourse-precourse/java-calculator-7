package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Cal {
    private String delimiter = ",|:";
    private String input;

    public int cal() {
        input = getInput();

        System.out.println("input = " + input);

        if (isCustomDelimiter()) {
            addCustomDelimiter();
        }

        String[] nums = input.split(delimiter);
        int total = 0;
        for (String num : nums) {
            total += parseNumber(num);
        }

        return total;
    }

    private boolean isCustomDelimiter() {
        String startCommand = "//";
        return input.startsWith(startCommand);
    }

    private void addCustomDelimiter() {
        String endCommand = "\\n";
        int endCommandIndex = input.indexOf(endCommand);

        String customDelimiter = input.substring(2, endCommandIndex);

        input = input.substring(endCommandIndex + endCommand.length());

        delimiter += ("|" + customDelimiter);
        System.out.println("custom delimiter added: " + customDelimiter);
    }

    private String getInput() {
        System.out.println("enter expression");
        return readLine();
    }

    private int parseNumber(String num) {
        try {
            int number = Integer.parseInt(num.trim());
            if (number < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed: " + num);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + num);
        }
    }
}
