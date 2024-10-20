package calculator;

import camp.nextstep.edu.missionutils.Console;
import utility.CheckDelimiter;
import utility.CheckValueCorrect;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputValue="";
        try{
            inputValue = Console.readLine().strip();
        } catch (RuntimeException e) { }

        int sum = 0;

        if(!inputValue.isEmpty()){
            try{
                CheckDelimiter cd = new CheckDelimiter();
                String[] delimiterAndSplitStr = cd.delimiter_strToSplit(inputValue);

                for(String value : delimiterAndSplitStr[1].split(delimiterAndSplitStr[0])){
                    if(!value.isEmpty()) {
                        CheckValueCorrect cvc = new CheckValueCorrect();
                        sum += cvc.strToInt(value);
                    }
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage()+"-".repeat(58)+"\n" +
                        "프로그램을 종료합니다.\n");
                throw new IllegalArgumentException();
            }
        }

        System.out.printf("결과 : %d\n", sum);
    }
}
