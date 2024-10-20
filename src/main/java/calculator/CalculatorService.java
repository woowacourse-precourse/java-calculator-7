package calculator;

public class CalculatorService {
    private final String input;

    public CalculatorService(String input) {
        this.input = input;
    }

    public void calculate() {

        try(Calculator calculator = new Calculator(input)) {
            calculator.process();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        } catch (Exception e){
            System.out.println("예기치 못한 오류입니다. 종료합니다.");
            System.out.println("[개발자용 로그]: " + e.getMessage());
        }
    }

}
