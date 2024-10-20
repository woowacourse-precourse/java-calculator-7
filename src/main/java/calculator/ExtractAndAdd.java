package calculator;
import java.util.*;

public class ExtractAndAdd {
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

        else if (input.charAt(0)=='/' || input.charAt(1)=='/'){
            customSeparator();
        }
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

    //3. 기본 구분자 외에 커스텀 구분자를 가지는 문자열에서 숫자 추출
    void customSeparator(){
        String value = "";
        String separator = "";
        int separatorLength = 0;
        //구분자 찾기
        for(int i=2; i<input.length(); i++) {
            separator += input.charAt(i);
            separatorLength += 1;
            if (input.charAt(i + 1) == '\\' && input.charAt(i + 2) == 'n') {
                break;
            }
        }

        // //과 \n로 인한 기본 문자열 길이
        for(int i=4+separatorLength; i<input.length(); i++){
            if(input.charAt(i) == separator.charAt(0) && i+separatorLength<=input.length()){
                String candidate = input.substring(i,i+separatorLength);
                if (separator.equals(candidate)) {
                    extractNumber.add(Integer.parseInt(value));
                    value = "";
                    continue;
                }
            }
            //커스텀구분자가 기본구분자를 포함하고 있을 경우 먼저 처리하면 안되기 때문에 이곳에 위치
            if(input.charAt(i) ==':' || input.charAt(i) ==','){
                extractNumber.add(Integer.parseInt(value));
                value = "";
            }

            //커스텀구분자가 숫자를 포함하고 있을 경우 먼저 처리하면 안되기 때문에 이곳에 위치
            // EX) "//2aa\n12aa22aa4"
            if(Character.isDigit(input.charAt(i))){
                value+=input.charAt(i);
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
