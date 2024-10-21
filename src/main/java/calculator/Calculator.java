package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public boolean isValidInput(String input) {
        if (input.isEmpty()) {
            return true;
        }

        List<Character> numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numList.add((char) (i + '0'));
        }

        List<Character> delimeterList = new ArrayList<>();
        delimeterList.add(',');
        delimeterList.add(':');

        String calculateZone = input;
        if (hasCustomDelimeter(input)) {
            delimeterList.add(input.charAt(2));

            if (input.length() <= 5) {
                return false;
            }

            calculateZone = input.substring(5);
        }

        for (int i = 0; i < calculateZone.length(); i++) {
            if (i == 0 && delimeterList.contains(calculateZone.charAt(i))) {
                return false;
            }

            if (delimeterList.contains(calculateZone.charAt(i))) {
                if (!numList.contains(calculateZone.charAt(i - 1))) {
                    return false;
                }
                if (i + 1 < calculateZone.length() && !numList.contains(calculateZone.charAt(i + 1))) {
                    return false;
                }
            } else if (!numList.contains(calculateZone.charAt(i))){
                return false;
            }
        }

        return true;
    }

    public BigInteger add(String input) {
        if (input.isEmpty()) {
            return BigInteger.ZERO;
        }

        List<Character> delimeterList = new ArrayList<>();
        delimeterList.add(',');
        delimeterList.add(':');

        String calculateZone = input;
        if (hasCustomDelimeter(input)) {
            delimeterList.add(input.charAt(2));
            calculateZone = input.substring(5);
        }

        int startIndex = 0;
        BigInteger total = BigInteger.ZERO;
        for (int i = 0; i < calculateZone.length(); i++) {
            if (delimeterList.contains(calculateZone.charAt(i))) {
                total = total.add(new BigInteger(calculateZone.substring(startIndex, i)));
                startIndex = i + 1;
            }
        }
        total = total.add(new BigInteger(calculateZone.substring(startIndex)));

        return total;
    }

    private boolean hasCustomDelimeter(String input) {
        if (input.length() < 5) {
            return false;
        }

        String substring1 = input.substring(0, 2);
        String substring2 = input.substring(3, 5);

        return (substring1.equals("//") && substring2.equals("\\n"));
    }
}
