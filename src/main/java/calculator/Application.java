package calculator;

import camp.nextstep.edu.missionutils.*;

public class Application {

    public static int StringCalculator(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",;";

        String[] tokens = input.split(delimiter);
        int sum = 0;

        for(String token : tokens) {
            try {
                sum += Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number format");
            }

        }
        return sum;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
