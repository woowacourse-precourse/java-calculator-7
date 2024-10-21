package calculator;

public class NumberInputPrompter {
    private final NumberInputReceiver numberInputReceiver = new NumberInputReceiver();

    public String numberInputReceive() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return numberInputReceiver.inputNumber();
    }
}
