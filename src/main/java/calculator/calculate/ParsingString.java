package calculator.calculate;

import calculator.global.GlobalConstant;
import calculator.exception.Exception;

import java.util.ArrayList;

public class ParsingString {
    private ArrayList<Character> delemeter;
    private String check_slash = "";
    private String check_line = "";
    private char adding_delemeter;
    private ArrayList<Integer> numlist = new ArrayList<Integer>();
    private String input;
    private String parsingInput;

    public void AddDelemeter() {
        if (LenCheck()) return;
        ParsingPattern();
        if (check_slash.equals("//") && check_line.equals("\\n")) {
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

    public ArrayList<Integer> MakeNumList() {
        parsingInput = input.substring(GlobalConstant.StartIndex);
        String tmp = "";
        for (int i = 0; i < parsingInput.length(); i++) {
            char currentChar = parsingInput.charAt(i);

            if (isDelimiter(currentChar)) {
                addNumToList(tmp);
                tmp = "";
            } else {
                tmp += currentChar;
            }
        }
        addNumToList(tmp);
        Exception.IsArrayNotEmpty(numlist);
        return numlist;
    }

    private boolean isDelimiter(char currentChar) {
        for (char delimiter : delemeter) {
            if (currentChar == delimiter) {
                return true;
            }
        }
        return false;
    }

    private void addNumToList(String tmp) {
        if (!tmp.isEmpty()) {
            int num = Exception.IsPositiveNum(tmp);
            numlist.add(num);
        }
    }

    public ParsingString(String input){
        this.input = input;
        this.delemeter = new ArrayList<>();
        delemeter.add(',');
        delemeter.add(':');
    }
}
