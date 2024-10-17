package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String str = Console.readLine();
        String regex = "[,:]";

        String[] array = str.split(regex);

        int result = 0;
        for (String s : array) {
            result += Integer.parseInt(s);
        }

        System.out.println(result);
    }
}
