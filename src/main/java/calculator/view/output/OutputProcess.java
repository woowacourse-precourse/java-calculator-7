package calculator.view.output;

public class OutputProcess implements InfoService, ResultService{

    @Override
    public void info() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    @Override
    public void result(long value) {
        System.out.printf("결과 : %d", value);
    }
}
