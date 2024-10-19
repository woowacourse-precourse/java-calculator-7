package calculator;

public class Output {
    private final int result;

    public Output(int result) {
        this.result = result;
    }

    public void printResult() {
        System.out.print("결과 : " + result);
    }
}
