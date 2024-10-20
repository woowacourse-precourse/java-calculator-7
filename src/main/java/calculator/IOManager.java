package calculator;

public class IOManager {

    public String inputCalculationString()
    {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        return input;
    }

    public void printCalculation(int val)
    {
        System.out.println("결과 : " + val);
    }
}
