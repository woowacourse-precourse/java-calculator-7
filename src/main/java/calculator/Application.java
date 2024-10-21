package calculator;
import java.lang.String;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        char customChar;
        String[] numbers;
        String inputString = getUserInput();
        if (isCustom(inputString)) {
            customChar = inputString.charAt(2);
            inputString = inputString.substring(5);
            numbers = inputString.split(String.valueOf(customChar));
        }
        else {
            //쉼표를 콜론으로 변경
            inputString = inputString.replace(',', ':');
            numbers = inputString.split(":");
        }
        //확인용 출력
        for(int i=0; i<inputString.length();i++){
            System.out.println(numbers[i]);
        }
    }

    public static String getUserInput() {
        System.out.print("덧셈할 문자열을 입력하세요: ");
        String inputString = Console.readLine();
        return inputString;
    }

    public static boolean isCustom(String inputString) {
        return inputString.charAt(0) == '/';
    }
}