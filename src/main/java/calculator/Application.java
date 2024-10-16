package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //setting dividers, getting inputs
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String dividers = ",:";
        String input = readLine();
        if (input.startsWith("//")) {
            int newlineidx = input.indexOf("\\n");
            //proper divider not given
            if (newlineidx == -1) {
                throw new IllegalArgumentException("No Following \\n given in input");
            }
            //changing custom divider by ,
            String customdivider = input.substring(2, newlineidx);
            input = input.substring(newlineidx + 2);
            input = input.replace(customdivider, ",");
        }
        // changing every divider to ,
        for (char divider : dividers.toCharArray()) {
            input = input.replace(divider, ',');
        }
        int answer = 0;
    }
}