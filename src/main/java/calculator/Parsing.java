package calculator;
import java.util.ArrayList;
import calculator.GlobalConstant;
import calculator.Exception;
public class Parsing {
    ArrayList<Integer> numlist = new ArrayList<>();
    Exception exception = new Exception();
    String input = "";
    ArrayList<String> delemeter = new ArrayList<String>();
    Parsing(String input, ArrayList<String> delemeter){
        this.delemeter = delemeter;
        this.input = input.substring(GlobalConstant.StartIndex,input.length());
    }
    //구분자를 기준으로 비교
    //Integer.parseInt 변환 실패시 NumberFormatException e 발생
    ArrayList<Integer> MakeNumList(){
        String regex = String.join("|", delemeter);
        String[] result = input.split(regex);
        for(String s : result){
            int tmp;
            tmp = exception.IsPositiveNum(s);
            numlist.add(tmp);
        }
        return numlist;
    }

}
