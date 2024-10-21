package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleIO {
    public String readInput(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return readLine();
    }

    public void printOutput(long output){
        System.out.printf("결과 : %d\n", output);
    }
}
