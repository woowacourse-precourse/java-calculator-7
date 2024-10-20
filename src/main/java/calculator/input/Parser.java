package calculator.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Parser {

    private static String inputString; //입력 문자열

    private static List<String> separators = new ArrayList<>(); //구분자들

    public Parser(String inputString){
        separators.add(",");
        separators.add(":");
        this.inputString = inputString;
    }

    public void extractCustomSeparator(){ //커스텀 구분자 추출
        while (inputString.startsWith("//") && inputString.contains("\\n")){
            separators.add(inputString.substring(2, inputString.indexOf("\\n")));
            inputString = inputString.substring(inputString.indexOf("\\n")+2, inputString.length());
        }
    }

    //숫자 추출
    public List<Integer> getNumbers(){

        extractCustomSeparator(); //커스텀 구분자 추출

        List<Integer> numbers = new ArrayList<>();

        if(isStringInteger(inputString)){ //입력 문자열에 숫자가 하나인 경우
            numbers.add(Integer.valueOf(inputString));
            return numbers;
        }

        String nums[];
        Vector<String> pharseInput = new Vector<>();

        pharseInput.add(inputString);

        for(String separator: separators){
            for(String i: pharseInput){ //파싱해야 하는 문자열 i
                if(i.contains(separator)){ //해당 구분자를 포함하고 있다면
                    pharseInput.remove(i);
                    nums = i.split(separator);
                    for (String num : nums) {
                        if(isStringInteger(num)) {
                            Integer n = Integer.valueOf(num);
                            if(n>0) numbers.add(Integer.valueOf(num)); //양의 정수인 경우
                            else throw new IllegalArgumentException("1 이상의 양의 정수만 입력이 가능합니다."); //아니라면, 오류 메시지 출력
                        }
                        else pharseInput.add(num);
                    }
                    break;
                }
            }
        }

        if(numbers.size()==0 && separators.size()>2) { //입력 문자열에 숫자가 없는 경우
            throw new IllegalArgumentException("입력 문자열에 숫자가 포함되어 있지 않습니다.");
        }

        if(pharseInput.size()>0){ //쉼표, 콜론, 커스텀 구분자가 아닌 구분자가 들어있는 경우
            throw new IllegalArgumentException("구분할 수 없는 구분자가 포함되어 있습니다.");
        }

        return numbers;
    }

    public boolean isStringInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
