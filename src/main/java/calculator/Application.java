package calculator;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String delimiter = "[,:]";
        String prefix = input.substring(0, 5);
        if(prefix.startsWith("//") && prefix.endsWith("\\n")) {
            delimiter = input.substring(2, 3);
            input = input.substring(5);
        }

        int result = 0;

        String[] splitArgs = input.split(delimiter);
        for(String arg : splitArgs) {
            try{
                int num = Integer.parseInt(arg);

                if(num < 0) {
                    throw new IllegalArgumentException();
                }
                result += num;

            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException(e);
            }
        }

        System.out.println("결과 : " + result);
    }
}
