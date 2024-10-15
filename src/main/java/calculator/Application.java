package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputMethod inputMethod = new InputMethod();
        SplitMethod splitMethod = new SplitMethod();

        System.out.println("덧셈할 문자열을 입력.");

        String input = inputMethod.input();

        int result = splitMethod.split(input);

        System.out.println("결과 : " + result);
    }
}
