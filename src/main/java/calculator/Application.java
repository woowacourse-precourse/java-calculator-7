package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int total = 0;

        System.out.println("덧셈할 문자열을 입력해주세요. ");
        String line = Console.readLine();

        String[] str = line.split(":|,");


        for (int i = 0; i < str.length; i++) {
            try {
                total += Integer.parseInt(str[i]);
            } catch (NumberFormatException e){
                total += 0;
            }
        }

        System.out.println("결과 : " + total);


    }
}
