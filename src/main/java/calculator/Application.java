package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();

    }

    private static String[] checkDelimiter(String inputStr){
        String[] values = {",|:", inputStr};

        if(inputStr.contains("//") && inputStr.contains("\\n")){
            int newLineIdx = inputStr.lastIndexOf("\\n");

            values[0] += "|"+inputStr.substring(2,newLineIdx);
            values[1] = inputStr.substring(newLineIdx+2, inputStr.length());
        }

        return values;
    }

    private static int checkIsInt(String str) throws IllegalArgumentException{
        return Integer.parseInt(str);
    }
}
