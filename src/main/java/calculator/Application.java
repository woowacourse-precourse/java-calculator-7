package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        String str = "1,2;34";
        String[] num = str.split("[,;]");

        int sum = 0;
        for (String cal : num){
            sum +=Integer.parseInt(cal);
        }
        System.out.println(sum);
    }
}
