package calculator.domain.calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private final Delimiter delimiter;

    private String inputStr;

    public Calculator(Delimiter delimiter){
        this.delimiter = delimiter;
    }

    public void getString(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String s = Console.readLine();
        Console.close();

        if(s.length()>=5 && s.charAt(0)=='/' && s.charAt(1)=='/'
                && s.charAt(3)=='\\' && s.charAt(4)=='n'){
            if( Character.isDigit(s.charAt(2))){
                throw new IllegalArgumentException();
            }
            delimiter.addDelimiter(s.charAt(2));
            s = s.substring(5);
        }

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if( !(Character.isDigit(ch) || delimiter.isDelimiter(ch))){
                throw new IllegalArgumentException();
            }
        }
        this.inputStr = s;
    }

}
