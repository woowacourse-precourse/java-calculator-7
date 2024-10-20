package calculator.service;

import java.util.List;

public class NumValidService extends Service{

    //입력 받은 문자열의 유효성 판단 (1)커스텀형식 (2)커스텀형식+기본구분자 (3)기본구분자 (4)예외
    public boolean inputValid(String input, List<String> separators) {
        //custom 구분자
        if(isCustom(input)){
            //custom구분자의 형식 판단
            return customValid(input);
        }
        else {
            if (input.contains("-")) {
                return false;
            }
            for (String separator : separators) {
                input = input.replaceAll(separator, "");
            }
            for(int i=0; i<input.length(); i++){
                int val = input.charAt(i);
                if(val < 48 || val > 57){
                    return false;
                }
            }
            return true;
        }
    }
    //커스텀 문자가 존재하는 경우  -> 존재하면 customValid()에서 유효성 판단
    public boolean isCustom(String str){
        if(str.contains(CUSTOM1) && str.contains(CUSTOM2)){
            return true;
        }
        return false;
    }

    //커스텀 문자가 들어간 경우 유효성 판단 (1)순서가 잘 들어갔는지 (2)커스텀 구분자가 null값인지 (3)커스텀 구분자가 숫자인지
    public boolean customValid(String str) {
        int customIdx1 = str.indexOf(CUSTOM1);
        int customIdx2 = str.indexOf(CUSTOM2);
        //구분자의 순서가 잘못됨
        if(customIdx1 > customIdx2){
            return false;
        }
        //공백이거나
        if(customIdx1+2 == customIdx2){
            return false;
        }
        if(customIdx1 != 0){
            return false;
        }
        String c = str.substring(customIdx1, customIdx2);
        for(int i=0; i<c.length(); i++){
            int charAtc = c.charAt(i);
            //사이에 들어있는 커스텀 구분자가 숫자일 경우
            if(charAtc <=57 && charAtc >= 48){
                return false;
            }
        }
        return true;
    }

}
