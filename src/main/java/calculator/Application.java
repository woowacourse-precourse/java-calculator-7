package calculator;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = InputReader.getInstance(StringSplitter.getInstance(), NumberConverter.getInstance(), SumCalculator.getInstance());
        int result = inputReader.readAndProcess();
        System.out.println("결과 : " + result); // 결과 출력
    }
}
