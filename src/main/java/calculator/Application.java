package calculator;


public class Application {
    public static void main(String[] args) {
        new Application().run();
    }

    public void run() {
        // 1. 문자열을 입력 받음.
        InputReader inputReader = new InputReader();
        String input = inputReader.getInput();
        System.out.println("입력된 값: " + input);
    }
}
