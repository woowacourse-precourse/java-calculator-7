package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calc = new Calculator();
    }
}

class Calculator {

    static Str str;
    static Delimiters delimiters;

    Calculator() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        str = new Str(Console.readLine());
        delimiters = getDelimiter();
    }

    public static Delimiters getDelimiter() {
        List<Character> delimiterList = new ArrayList<>();
        if(str.checkingCustomDelimiter()){
            delimiterList.add(str.getCustomDelimiter());
            return new Delimiters(delimiterList);
        }

        delimiterList.add(',');
        delimiterList.add(':');
        return new Delimiters(delimiterList);
    }
}

class Str {

    private static String string;

    Str(String string) {
        this.string = string;
    }

    boolean checkingCustomDelimiter() {
        return (string.substring(0, 2).equals("//") && string.charAt(3) == '\\'
            && string.charAt(4) == 'n');

    }

    Character getCustomDelimiter(){
        return string.charAt(2);
    }
}

class Delimiters{
    private List<Character> delimiterList;
    public Delimiters(List<Character> delimiterList){
        this.delimiterList = delimiterList;
    }
}