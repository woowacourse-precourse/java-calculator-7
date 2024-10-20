package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator cal = new Calculator();

        cal.Calculation("1:2,3"); // 계산기 호출
        cal.Calculation("1,2,3"); // 계산기 호출
        cal.Calculation("1:2:3"); // 계산기 호출
        cal.Calculation("//;\\n1;2;3"); // 계산기 호출
    }
}
