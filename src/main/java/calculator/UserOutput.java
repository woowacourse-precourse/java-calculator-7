package calculator;

public class UserOutput {

    private int answer;

    public void print() {
        StringBuilder sb = new StringBuilder();

        sb.append("결과 : ");
        sb.append(answer);
        System.out.println(sb);
    }

    public UserOutput(int answer) {
        this.answer = answer;
    }
}
