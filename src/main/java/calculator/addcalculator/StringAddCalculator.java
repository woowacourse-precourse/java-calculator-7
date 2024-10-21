package calculator.addcalculator;

import java.util.*;

public class StringAddCalculator {

    String inputString;
    String resultString;
    List<Character> delimeterCharters = new ArrayList<>();

    //NOTE입력받는 순간 계산을 진행한다면 굳이 배열 설정 보다 전역 변수 설정이 더 효과적일 수도 있다.
    int nowSum = 0;


    public StringAddCalculator(String inputString){
        if (inputString == null || inputString.isEmpty()) {
            this.inputString = "";
            this.resultString = "0";
        } else {
            this.inputString = inputString;
            setParseStringInit();
            calculateProcess();
        }
    }

    public String getInputString(){
        return this.inputString;
    }
    public String getResultString(){
        return this.resultString;
    }


    public void calculateProcess(){
        int n = inputString.length();
        int idx = 0;
        int length = 0;

        if(inputString.charAt(0) == '/' && inputString.charAt(1)=='/'){
            idx = setDelimeter();
        }

        while(idx < n){
            char nowChar = inputString.charAt(idx);
            //System.out.println("now = \t" + nowChar);//FIXME
            if(isNum(nowChar)){
                length++;
                idx++;
                if(idx == n){
                    setAddNum(length, idx);
                    resultString = ""+nowSum;
                    return;
                }
            }
            else{
                if(idx==n-1){
                    //예외 상황으로 임시로 처리해둠
                    throw new IllegalArgumentException("구분자가 문자열 마지막에 옴");                   //FIXME 예외처리
                }

                if(delimeterCharters.contains(nowChar)){
                    if(length == 0)throw new IllegalArgumentException("앞에 숫자 없음");        //FIXME 예외처리
                    setAddNum(length, idx);
                    length = 0;
                    idx = idx + 1;
                }
                else{
                    throw new IllegalArgumentException("잘못된 문자 입력");                   //FIXME 예외처리
                }
            }
        }
        resultString = ""+nowSum;
        //System.out.println("resultString = \t" + resultString);//FIXME
    }

    public void setAddNum(int length, int idx){
        try{
            int num = Integer.parseInt(inputString.substring(idx-length, idx));
            nowSum += num;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public boolean isNum(char c){
        return c>='0' && c<='9';
    }

    public void setParseStringInit(){
        delimeterCharters.add(',');
        delimeterCharters.add(':');
    }

    //구분자 찾는 로직 따로 분류한다.
    public int setDelimeter(){

        int delimeterStartIdx = 0;
        int delimeterEndIdx = inputString.indexOf("\n");
        if(delimeterEndIdx == -1){
            delimeterEndIdx = inputString.indexOf('n');
            if(inputString.charAt(delimeterEndIdx-1) == '\\'){
                delimeterEndIdx = delimeterEndIdx - 1;
            }
            throw new IllegalArgumentException("구분자 오류");           //FIXME
        }
        for(int i = 2; i<delimeterEndIdx; i++){
            char delimeter = inputString.charAt(i);
            if(!delimeterCharters.contains(delimeter)){
                delimeterCharters.add(delimeter);
            }
        }
        return delimeterEndIdx + 1;
    }


/*************************************temporary code - start*************************************/

/*************************************temporary code - end*************************************/



}
