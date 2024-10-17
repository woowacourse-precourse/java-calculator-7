package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String s = Console.readLine();

        Calculator c = new Calculator(s);
        c.run();
    }
}

class Calculator {
    private String s;
    private String plusSeparator;

    public Calculator(String s) {
        if(s.isEmpty())
            throw new IllegalArgumentException();
        this.s = s;
    }

    /** Run all logic step by step. */
    public void run() {
        boolean hasPlusSeparator = checkPlusSeparator();
        String[] separatedStringArr = separate(hasPlusSeparator);
        hasNaN(separatedStringArr);
        System.out.println("결과 : " + sum(separatedStringArr));
    }
    /**
     * Check existence of another separator.
     * @return if exist another separator, return true. Or return false.
     */
    private boolean checkPlusSeparator() {
        if (s.length() >= 5 && s.startsWith("//") && s.startsWith("\\n", 3)) {
            plusSeparator = String.valueOf(s.charAt(2));
            s = s.substring(5);
            return true;
        }
        return false;
    }

    /**
     * Separate input string. if escape string(\) added separator, need action.
     * @param hasPlusSeparator if another separator exist, set true. Or false.
     * @return separated string.
     */
    private String[] separate(boolean hasPlusSeparator) {
        if (!hasPlusSeparator) {
            return s.split("[:,]");
        }
        if (plusSeparator.equals("\\")) {
            return s.split("[:," + plusSeparator.repeat(2) + "]");
        }
        return s.split("[:," + plusSeparator + "]");
    }

    /**
     * Check input string array contains not a number. if it contains NaN,
     * throw IllegalArgumentException.
     * @param separatedStringArr String separated by separator.
     */
    private void hasNaN(String[] separatedStringArr) {
        for (String s : separatedStringArr) {
            for (char c : s.toCharArray()) {
                if (c < 48 || c > 57) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    /**
     * Sum all of them
     * @param separatedStringArr clean integer string array.
     * @return Sum
     */
    private int sum(String[] separatedStringArr) {
        int sum = 0;
        for (String separatedString : separatedStringArr) {
            sum += Integer.parseInt(separatedString);
        }
        return sum;
    }
}
