package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현f

        try {
            System.out.println("write number. (. or :)");
            String input = camp.nextstep.edu.missionutils.Console.readLine();
            int result = Calculate.sum(input);
            System.out.println("result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
