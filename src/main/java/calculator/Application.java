package calculator;
import java.lang.String;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputString = getUserInput();
        String[] numbers = extractNumbers(inputString);
        int sum = addNumbers(numbers);
        System.out.println("결과: " + sum);
    }

    public static String getUserInput() {
        System.out.print("덧셈할 문자열을 입력하세요: ");
        return Console.readLine();
    }

    public static boolean isCustom(String inputString) {
        return inputString.charAt(0) == '/';
    }

    public static String[] extractNumbers(String inputString){
        if (inputString.isEmpty()){
            return new String[0];
        }
        char customChar;
        if (isCustom(inputString)) {
            customChar = inputString.charAt(2);
            inputString = inputString.substring(5);
            return inputString.split(String.valueOf(customChar));
        }
        else {
            //쉼표를 콜론으로 변경
            inputString = inputString.replace(',', ':');
            return inputString.split(":");
        }
    }

    public static int addNumbers(String[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
            //확인용 출력
            System.out.println(sum);
        }
        return sum;
    }
}