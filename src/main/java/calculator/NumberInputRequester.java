package calculator;

public class NumberInputRequester {
    private final NumberInPutter inPutter = new NumberInPutter();

    public String numberInputRequest() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return inPutter.inputNumber();
    }
}
