package calculator;
import java.lang.String;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try{
            String inputString = getUserInput();
            String[] numbers = extractNumbers(inputString);
            int sum = addNumbers(numbers);
            System.out.println("결과 : " + sum);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
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
            String newinputString = inputString.substring(5);
            //확인용 출력
            newinputString = newinputString.replace(customChar, ':');
            String[] numbers = newinputString.split(":");
            for (int i = 0; i < numbers.length; i++) {
                System.out.println(numbers[i]);
            }
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
                sum += Integer.parseInt(numbers[i]);
                //확인용 출력
                System.out.println(sum);
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
        }
        return sum;
    }
}