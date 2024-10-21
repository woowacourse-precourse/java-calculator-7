package calculator;
import java.lang.String;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String inputString = getUserInput();
        String[] numbers = extractNumbers(inputString);
        int sum = addNumbers(numbers);
        System.out.println("결과 : " + sum);
    }

    public static String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요");
        return Console.readLine();
    }

    public static boolean isCustom(String inputString) {
        return inputString.startsWith("//");
    }

    public static String[] extractNumbers(String inputString){
        if (inputString.isEmpty()){
            return new String[0];
        }
        char customChar;
        if (isCustom(inputString)) {
            customChar = inputString.charAt(2);
            String newinputString = inputString.substring(inputString.indexOf("\\n")+2);newinputString = newinputString.replace(customChar, ':');
            String[] numbers = newinputString.split(":");
            return numbers;
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
            try{
                int number = Integer.parseInt(numbers[i]);
                if (number < 0){
                    throw new IllegalArgumentException("음수 입력");
                }
                sum += number;
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException("잘못된 입력");
            }
        }
        return sum;
    }
}