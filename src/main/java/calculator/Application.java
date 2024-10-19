package calculator;


public class Application {
    public static void main(String[] args) {

        String description = "덧셈할 문자열을 입력해 주세요.";
        String result = "결과 : ";

        System.out.println(description);
        String input = camp.nextstep.edu.missionutils.Console.readLine();

        Calculator cal = new calculator.Calculator();
        cal.readInput(input);

        long res = cal.sum();

        result = result.concat(String.valueOf(res));

        System.out.println(result);


    }
}
