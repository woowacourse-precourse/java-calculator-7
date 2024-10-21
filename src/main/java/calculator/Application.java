package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Application {

    //문자열이 비었거나 null인 경우 0을 반환하고 프로그램을 끝내기 위해 생성
    public static boolean isBlankOrNull(String sentence){
        return sentence.isBlank() || sentence == null;
    }

    public static String extractLetter(String str){
        char firstLetter = str.charAt(0);
        //:와 ,로 구분되는 경우
        if(firstLetter == ':' || firstLetter == ',' || Character.isDigit(firstLetter)){
            return ":|,";
        }
        //커스텀 구분자를 쓰는 경우
        else if(firstLetter == '/') {
            return extractCustomLetter(str);
        }
        //잘못된 입력
        throw new IllegalArgumentException("[extractLetter] 잘못된 입력");
    }

    public static String extractCustomLetter(String str){
        if(str.length() > 2){
            return str.substring(2);
        }

        throw new IllegalArgumentException("[extractCustomLetter] 잘못된 입력");
    }

    public static void main(String[] args) {
        String str = Console.readLine();
        int result = 0;

        if(!isBlankOrNull(str)){
            String letter = extractLetter(str);
            System.out.println(letter);
        }


    }
}
