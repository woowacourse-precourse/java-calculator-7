package calculator;
import calculator.GlobalConstant;

import java.util.ArrayList;

public class Checkdelemeter {

    ArrayList<String> delemeter = new ArrayList<String>();
    String slash = "//";
    String line = "\\\\n";
    String check_slash = "";
    String check_line = "";
    String adding_delemeter;

    ArrayList<String> AddDelemeter(String input){
        //최소 길이가 5 이상이어야 delemeter확인 가능
        //길이가 5 미만이라는 말은 구분자 가능성 없다는 말
        if(input.length() < 6){
            return delemeter;
        }
        check_slash = input.substring(0,2);
        check_line = input.substring(3,6);

        //input의 사이즈 확인 예외처리
        if(slash.equals(check_slash) && line.equals(check_line)){
            adding_delemeter = Character.toString(input.charAt(2));
            delemeter.add(adding_delemeter);
            GlobalConstant.StartIndex = 6;
            // delemeter가 유효한 char인지 예외처리
        }
        return delemeter;
    }
    Checkdelemeter(){
        delemeter.add(",");
        delemeter.add(":");
    }
}
