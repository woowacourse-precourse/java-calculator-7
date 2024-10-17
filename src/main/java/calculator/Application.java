package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calc = new Calculator();
        //System.out.println("결과 : "+calc.sum());
    }
}

class Calculator {

    static Str str;
    static Delimiters delimiters;
    static Numbers numbers;

    Calculator() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        str = new Str(Console.readLine());
        delimiters = getDelimiter();
        StrArr strArr = str.getSplitString();
        numbers = strArr.strArrToNumbers();
    }

    public static Delimiters getDelimiter() {
        List<Character> delimiterList = new ArrayList<>();
        if (str.checkingCustomDelimiter()) {
            delimiterList.add(str.getCustomDelimiter());
            return new Delimiters(delimiterList);
        }

        delimiterList.add(',');
        delimiterList.add(':');
        return new Delimiters(delimiterList);
    }
    /*
    public int sum(){
        return numbers.sum();
    }
    */
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

    Character getCustomDelimiter() {
        return string.charAt(2);
    }

    StrArr getSplitString() {
        String[] strings;

        if (checkingCustomDelimiter()) {
            char customDelimiter = getCustomDelimiter();
            string = string.substring(5);
            strings = string.split(String.valueOf(customDelimiter));
            return new StrArr(strings);
        }

        strings = string.split(",|:");
        return new StrArr(strings);
    }

}

class Delimiters {

    private List<Character> delimiterList;

    public Delimiters(List<Character> delimiterList) {
        this.delimiterList = delimiterList;
    }
}

class StrArr {

    private String[] stringArr;

    public StrArr(String[] stringArr) {
        this.stringArr = stringArr;
    }

    public boolean checkingRightInput() {
        int number;
        for (int i = 0; i < stringArr.length; i++) {
            try {
                number = Integer.parseInt(stringArr[i]);
                if (number < 0) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public Numbers strArrToNumbers() {
        if (!checkingRightInput()) {
            throw new IllegalArgumentException();
        }

        List<Integer> numberList = new ArrayList<>();
        for (String string : stringArr) {
            numberList.add(Integer.parseInt(string));
        }

        return new Numbers(numberList);
    }
}


class Numbers {

    private List<Integer> numberList;

    public Numbers(List<Integer> numberList) {
        this.numberList = numberList;
    }

    /*
    public int sum(){
        return numberList.stream().mapToInt(i->i).sum();
    }
    */
}

