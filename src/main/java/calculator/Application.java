package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String targetString = Input.read();
        int result = -1;
        Output.handleResult(result);
    }
}



class Input {
    private static final String INPUT_INSTRUCTION = "덧셈할 문자열을 입력해 주세요.";

    public static String read(){
        System.out.println(INPUT_INSTRUCTION);
        return Console.readLine();
    }
}

class Output {
    private static final String OUTPUT_FORMAT = "결과 : ";
    public static void handleResult(int result){
        if (result < 0) return;

        System.out.println(OUTPUT_FORMAT+result);
    }
}
