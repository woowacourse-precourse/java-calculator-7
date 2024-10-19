package calculator;

public class UserOutput {

    private int answer;

    public void print() {
        System.out.println("결과 : " + answer);
    }

    public UserOutput(int answer) {
        this.answer = answer;
    }
}
