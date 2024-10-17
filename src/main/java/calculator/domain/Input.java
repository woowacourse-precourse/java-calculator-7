package calculator.domain;

public class Input {

    private String firstInput;
    private String secondInput;

    public Input(String firstInput) {
        this.firstInput = firstInput;
    }

    //입력이 기본 형식인지 커스텀 형식인지 판단하는 메소드
    public boolean isDefaultInput() {
        return !firstInput.startsWith("//");
    }
}
