package calculator;

public class StringCalculator {

    public int add(String input) {
        System.out.println("입력된 값: '" + input + "'");
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        return -1;
    }
}
