package calculator;


public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Calculate calculate;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = input.nextLine();
        calculate = new Calculate(str);

        int res = calculate.cal();

        StringBuilder sb = new StringBuilder();
        sb.append("결과 : ").append(res);
    }
}
