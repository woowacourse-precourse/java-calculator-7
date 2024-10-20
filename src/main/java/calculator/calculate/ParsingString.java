package calculator.calculate;

import calculator.global.GlobalConstant;
import calculator.exception.Exception;

import java.util.ArrayList;

public class ParsingString {

    private ArrayList<Character> delemeter;
    String check_slash = "";
    String check_line = "";
    char adding_delemeter;
    ArrayList<Integer> numlist = new ArrayList<Integer>();
    String input;
    String parsingInput;

    public void AddDelemeter(){
        if(LenCheck()) return ;
        ParsingPattern();
        if(check_slash.equals("//") && check_line.equals("\\n")){
            Exception.IsDelemeterChar(input.charAt(2));
            adding_delemeter = input.charAt(2);
            delemeter.add(adding_delemeter);
            GlobalConstant.StartIndex = 5;
        }
    }
    public void ParsingPattern(){
        check_slash = input.substring(0,2);
        check_line = input.substring(3,5);
    }
    public boolean LenCheck(){
        if(input.length() < 5) return true;
        else return false;
    }
    public ArrayList<Integer> MakeNumList(){
        parsingInput = input.substring(GlobalConstant.StartIndex,input.length());
        String tmp = ""; // 임시로 숫자를 저장할 문자열
        for (int i = 0; i < parsingInput.length(); i++) {
            char currentChar = parsingInput.charAt(i);
            // 구분자 배열을 확인하여 현재 문자가 구분자인지 체크
            boolean isDelimiter = false;
            for (char delimeter : delemeter) {
                if (currentChar == delimeter) {
                    isDelimiter = true;
                    break;
                }
            }
            if (isDelimiter) {
                int num = Exception.IsPositiveNum(tmp);
                numlist.add(num);
                tmp = "";
            } else {
                tmp += currentChar;
            }
        }
        int num = Exception.IsPositiveNum(tmp);
        Exception.IsArrayNotEmpty(numlist);
        numlist.add(num);
        return numlist;
    }

    public ParsingString(String input){
        this.input = input;
        delemeter.add(',');
        delemeter.add(':');
    }
}
