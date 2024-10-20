package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String a = Console.readLine();
        String b = Console.readLine();
        System.out.println(Integer.parseInt(a)+Integer.parseInt(b));
    }
}
