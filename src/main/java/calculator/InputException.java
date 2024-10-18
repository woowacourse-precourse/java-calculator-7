package calculator;

public class InputException extends IllegalArgumentException{
    public InputException() {
        System.out.println("음수는 입력할 수 없습니다.");
    }
}
