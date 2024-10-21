package calculator;
import java.lang.String;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int sum = 0;
        String inputString = getUserInput();
        System.out.println("입력된 문자열: " + inputString);  //확인용 출력
    }
    public static String getUserInput(){
        System.out.print("덧셈할 문자열을 입력하세요: ");
        String inputString = Console.readLine();
        return inputString;
    }
}
