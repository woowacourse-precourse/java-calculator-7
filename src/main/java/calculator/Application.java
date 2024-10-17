package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //setting dividers, getting inputs
        System.out.println("덧셈할 문자열을 입력해주세요.");
        StringBuilder dividers =new StringBuilder(",:");
        String input = readLine();
        if (input.startsWith("//")) {
            int newlineidx = input.indexOf("\\n");
            //proper divider not given
            if (newlineidx == -1) {
                throw new IllegalArgumentException("No Following \\n given in input");
            }
            //changing custom divider by ,
            String customdivider = input.substring(2, newlineidx);
            input=input.substring(newlineidx+2);
            dividers.append(customdivider);
        }
        // changing every divider to ,
        for (int i=0;i<dividers.length();i++) {
            input=input.replace(dividers.charAt(i),',');
        }
        int answer=0;

}
}