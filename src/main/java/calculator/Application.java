package calculator;
import camp.nextstep.edu.missionutils.Console;


public class Application {

    static String result;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(Constants.REQUEST);
        String rawString = Console.readLine();

        StringProcessing.processString(rawString);



    }
}
