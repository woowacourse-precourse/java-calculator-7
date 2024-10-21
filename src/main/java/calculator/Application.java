package calculator;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자를 쓰시오. 기본 구분문자(. 또는 :)");
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        int result = Calculate.sum(input);
        System.out.println("결과 : " + result);
    }
}
