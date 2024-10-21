package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String input = readLine();

        try{
            int result = add(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static int add(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }

        return 0;
    }
}
