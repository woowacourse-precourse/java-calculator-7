package calculator;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요. ");
        String input = Console.readLine();

        if (input.isEmpty()) {
            System.out.println(0);
            return;
        }

        String[] inputArray;
        int num = 0;

        if (input.startsWith("//")) {
            int endIdx = input.indexOf("\\n");
            String separator = input.substring(2, endIdx);
            inputArray = input.substring(endIdx + 2).split(separator);
        } else {
            inputArray = input.split("[,:]");
        }

        for (String s : inputArray) {
            if (!s.matches("\\d+")) {
                throw new IllegalArgumentException();
            }
            num += Integer.parseInt(s);
        }

        System.out.println("결과 : " + num);
    }
}
