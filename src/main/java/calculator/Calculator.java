package calculator;

import java.util.List;

public class Calculator {
    private int sum;

    public int getSum(String parsedUserInput, List<Character> delimiter) {
        searchNumberAndCalculate(parsedUserInput, delimiter);

        return sum;
    }

    private void searchNumberAndCalculate(String parsedUserInput, List<Character> delimiter) {
        StringBuilder sb = new StringBuilder();
        this.sum = 0;

        for (int i = 0; i < parsedUserInput.length(); i++) {
            if (!delimiter.contains(parsedUserInput.charAt(i))) {
                sb.append(parsedUserInput.charAt(i));
            } else {
                parseNumberAndSum(parsedUserInput, i, sb);
            }
        }

        if (sb.length() != 0) {
            sum += Integer.parseInt(sb.toString());
            sb.delete(0, sb.length());
        }
    }

    private void parseNumberAndSum(String parsedUserInput, int i, StringBuilder sb) {
        if (parsedUserInput.length() - 1 == i) {
            if (Character.isDigit(parsedUserInput.charAt(i))) {
                sb.append(parsedUserInput.charAt(i));
                sum += Integer.parseInt(sb.toString());
                sb.delete(0, sb.length());
            }
        }

        if (sb.length() == 0) {
            return;
        }

        sum += Integer.parseInt(sb.toString());
        sb.delete(0, sb.length());
    }
}
