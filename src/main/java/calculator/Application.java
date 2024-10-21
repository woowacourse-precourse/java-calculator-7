package calculator;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split("[,:]");

        if (input.startsWith("//")) {
            String delimiter = input.substring(2, input.indexOf("\n"));
            input = input.substring(input.indexOf("\n") + 1);
            numbers = input.split(delimiter);
        }
    }
}
