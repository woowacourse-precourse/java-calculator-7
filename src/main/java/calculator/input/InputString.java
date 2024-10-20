package calculator.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputString {

    private String inputString = "";
    private List<String> separators = new ArrayList<>();

    public List<Integer> input(){ //문자열 입력받기
        inputString = readLine();

        List<Integer> number = findSeparator(inputString);

        return number;
    }

    public List<Integer> findSeparator(String inputString){ //커스텀 구분자 추출
        separators.add(",");
        separators.add(":");

        Integer startIdx = inputString.indexOf("//");

        if(startIdx!=-1){ //커스텀 문자를 지정해주는 경우, 여러 개를 지정하는 경우도 처리
            Integer endIdx = null;
            while(startIdx!=-1){

                endIdx = inputString.indexOf("\\n", startIdx+1);
                if(endIdx!=-1){
                    separators.add(inputString.substring(startIdx+2, endIdx-1));
                }
                startIdx = inputString.indexOf("//", endIdx+1);
            }
            inputString = inputString.substring(endIdx+2); // 커스텀 문자열 입력 부분 제거
        }

        List<Integer> number = new ArrayList<>();
        if(isStringInteger(inputString)) number.add(Integer.parseInt(inputString)); //입력 문자열에 구분자 없이 숫자만 있는 경우(ex. 123)
        else number = extractNumber(inputString);

        return number;
    }

    //숫자 추출
    public List<Integer> extractNumber(String inputString){
        List<Integer> number = new ArrayList<>();
        String nums[];
        Vector<String> pharseNum = new Vector<>();
        pharseNum.add(inputString);

        for(String separator: separators){
            for(String i: pharseNum){ //구분자를 기준으로 파싱해야 하는 문자열 i
                if(i.contains(separator)){ //고려해야 할 구분자를 포함하고 있다면
                    pharseNum.remove(i);
                    nums = i.split(separator);

                    for (String num : nums) {
                        if(isStringInteger(num)) {
                            Integer n = Integer.valueOf(num);
                            if(n>0) number.add(Integer.valueOf(num)); //양의 정수인 경우
                            else throw new IllegalArgumentException("1 이상의 양의 정수만 입력이 가능합니다."); //아니라면, 오류 메시지 출력
                        }
                        else pharseNum.add(num);
                    }
                    break;
                }
            }
        }

        if(number.size()==0 && separators.size()>2) { //입력 문자열에 숫자가 없는 경우
            throw new IllegalArgumentException("입력 문자열에 숫자가 포함되어 있지 않습니다.");
        }

        if(pharseNum.size()>0){ //쉼표, 콜론, 커스텀 구분자가 아닌 구분자가 들어있는 경우
            throw new IllegalArgumentException("구분할 수 없는 구분자가 포함되어 있습니다.");
        }

        return number;
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
