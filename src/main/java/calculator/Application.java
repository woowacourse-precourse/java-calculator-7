package calculator;

public class Application {
    public static void main(String[] args) {

      String input = InputService.readLine();
      int result = OperationService.sumStringNum(input);

      System.out.println("결과 : " + result);
    }
}
