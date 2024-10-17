package calculator;
import java.util.ArrayList;
import calculator.GlobalConstant;
import calculator.Exception;
public class Parsing {
    int start_index = 0;
    ArrayList<String> numlist = new ArrayList<>();
    char[] delemeter = new char[3];

    Parsing(char[] delemeter){
        start_index = GlobalConstant.StartIndex;
        this.delemeter = delemeter;
    }

    //구분자를 기준으로 비교
    //Integer.parseInt 변환 실패시 NumberFormatException e 발생
    ArrayList<String> MakeNumList(String input){
        Exception exception = new Exception();
        String tmp = "";
        int break_point = 0;
        for(int i = start_index; i < input.length(); i++){
            char index = input.charAt(i);
            for(int j = 0; j < 3; j++){
                if(delemeter[i] == index){
                    break_point = 1;
                    break;
                }
            }
            if(break_point == 0){
                tmp += input.charAt(i);
            }else{
                //tmp가 숫자로 구성되어 있는게 맞는지 확인
                if(exception.IsNum(tmp) == 1){
                    numlist.add(tmp);
                }
                tmp = "";
                break_point = 0;
            }
        }
        return numlist;
    }



}
