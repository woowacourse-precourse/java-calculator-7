package calculator.view;

public class Output {

    private static final Output output = new Output();

    public static void printOutput(int sum) {
        System.out.println("결과: " + sum);
    }

}
