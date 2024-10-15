package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();

        int sum = 0;
        if(!inputStr.trim().isEmpty()){
            String[] values = checkDelimiter(inputStr);
            try {
                for (String value : values[1].split(values[0])) {
                    sum += checkIsInt(value);
                }
            } catch (IllegalArgumentException e) {
                System.out.print("잘못된 값을 입력했습니다. 프로그램을 종료합니다.");
                return;
            }
        }
        System.out.printf("결과 : %d", sum);
    }

    private static String[] checkDelimiter(String inputStr){
        String[] values = {",|:", inputStr};

        if(inputStr.contains("//") && inputStr.contains("\\n")){
            int newLineIdx = inputStr.lastIndexOf("\\n");

            values[0] += "|"+inputStr.substring(2,newLineIdx);
            values[1] = inputStr.substring(newLineIdx+2);
        }

        return values;
    }

    private static int checkIsInt(String str) throws IllegalArgumentException{
        int intValue = Integer.parseInt(str);
        if(intValue > 0) {
            return  intValue;
        }else{
            throw  new IllegalArgumentException();
        }
    }
}
