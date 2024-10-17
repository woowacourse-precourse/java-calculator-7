package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static Boolean CustomDiscrimination(String input){
        if (input.startsWith("//") && input.contains("\\n"))
            return true;
        else if (!input.startsWith("//") && !input.contains("\\n"))
            return false;
        else
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        Boolean isCustom = CustomDiscrimination(str);
    }
}
// //;\n1,2:3