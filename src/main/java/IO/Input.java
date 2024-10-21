package IO;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String input;
    public void message(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }
    public String input(){
         input = Console.readLine();
         return input;
    }
}
