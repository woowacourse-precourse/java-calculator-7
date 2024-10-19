package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Cal {
    private String delimiter = ",|:";
    private String input;

    public int cal() {
        input = getInput();
        if (isCustomDelimiter()) {
            addCustomDelimiter();
            input = getInput();
        }

        String[] nums = input.split(delimiter);
        int total = 0;
        for (String num : nums) {
            total += Integer.parseInt(num);
        }

        return total;
    }

    private boolean isCustomDelimiter() {
        return input.startsWith("//");
    }

    private void addCustomDelimiter() {
        String customDelimiter = input.substring(2);
        delimiter += ("|" + customDelimiter);
        //System.out.println("custom delimiter added: " + customDelimiter);
    }

    private String getInput() {
        System.out.println("enter expression");
        return readLine();
    }
}
