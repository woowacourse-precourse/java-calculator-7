package calculator;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculatorMain = new Calculator();
        try {
            System.out.println("결과 : " + calculatorMain.run());
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (Exception all) { // 예상하지 못한 예외 처리
            System.err.println("예상하지 못한 오류 발생: " + all.getMessage());
        }
    }
}
