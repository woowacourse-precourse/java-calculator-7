package calculator;
import java.util.*;

public class ExtractAndAdd {
    //basicSeparator
    String input;
    List<Integer> extractNumber;

    ExtractAndAdd(String input){
        this.input = input;
        this.extractNumber = new ArrayList<>();
    }

    public void checkFirstChar(){
        if (Character.isDigit(input.charAt(0))){
            basicSeparator();
        }

        //3. 기본 구분자 외에 커스텀 구분자를 가지는 문자열에서 숫자 추출
    }

    //2. 기본 구분자(, or :)를 구분자로 가지는 문자열에서 숫자 추출
    void basicSeparator(){
        String value = "";
        for(int i=0; i<input.length(); i++){

            if(Character.isDigit(input.charAt(i))){
                value+=input.charAt(i);
            }
            //구분자를 만나면 숫자 추출
            else if(input.charAt(i) ==':' || input.charAt(i) ==','){
                extractNumber.add(Integer.parseInt(value));
                value = "";
            }

            // 5.예외처리
            else{
            }

            //마지막 구분자 뒤에 존재하는 수 처리
            if(i==input.length()-1 && value!=""){
                extractNumber.add(Integer.parseInt(value));
            }
        }
    }
}
