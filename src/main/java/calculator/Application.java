package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = Console.readLine();

        try{
            int sum = StringCalculator.calculate(str);
            System.out.println("결과 : " + sum);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
