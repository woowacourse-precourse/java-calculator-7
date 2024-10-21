package calculator;

import camp.nextstep.edu.missionutils.*;

public class StringCalculator {

    public void calculate() {

        String str = Console.readLine();

        if (str.matches("//.\\\\n.*")) {
            String s = Character.toString(str.charAt(2));

            String regex = "(\\d" + "[,:" + s + "])*\\d";

            if (str.matches("//[\\S&&\\D]\\\\n" + regex)) {

                System.out.println("결과 : " + sum(str, 5));
            } else {
                throw new IllegalArgumentException();
            }
        } else {

            String regex = "(\\d[,:])*\\d";

            if (str.matches(regex)) {

                System.out.println("결과 : " + sum(str, 0));
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private int sum(String str, int start) {

        int sum = 0;
        int tmp = 0;
        int digit = 1;
        char[] charArray = str.toCharArray();
        for (int i = start; i < charArray.length; i++) {

            if (Character.isDigit(charArray[i])) {
                tmp = charArray[i] - '0' + (tmp * digit);
                digit *= 10;
            } else {
                sum += tmp;
                tmp = 0;
                digit = 1;
            }
        }
        sum += charArray[charArray.length - 1] - '0';

        return sum;
    }
}
