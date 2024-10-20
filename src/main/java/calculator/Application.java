package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        int result = 0;

        try {
            String inputStr = Console.readLine();

            if (inputStr.charAt(0) == '/' && inputStr.charAt(1) == '/') {
                String pivot = inputStr.substring(2, inputStr.indexOf('\\'));
                String target = inputStr.substring((inputStr.indexOf("n") + 1));

                String[] split = target.split(pivot);

                for (String s : split) {
                    int num = Integer.parseInt(s);
                    result += num;
                }
            } else {
                String[] split = inputStr.split(":|,");
                for (String s : split) {
                    int s1 = Integer.parseInt(s);
                    result += s1;
                }
            }

            if (inputStr.contains("-")){
                throw new IllegalArgumentException("잘못된 입력입니다. 자연수만 압력해주세요.");
            }
        } catch (StringIndexOutOfBoundsException e) {
            result = 0;
        }

        System.out.print("결과 : "+ result);

    }

}
