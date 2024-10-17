package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

// 문자열 계산기 클래스
public class StringCalculator {

    String inputString = ""; // 입력받는 문자열
    Character customSeparator = null; // 커스텀 구분자
    Calculation calculation = new Calculation(); // 연산 클래스

    //사용자로부터 문자열을 입력받음
    public void input(){


        System.out.println("덧셈할 문자열을 입력해 주세요.");

        //문자열 입력받기
        readString();
        inputString = inputString.trim();

        if(inputString.length()>255){
            throw new IllegalArgumentException("문자열의 최대 길이가 255자를 넘을 수 없습니다.");
        }

        // 문자열이 "//"로 시작할 때
        if(this.inputString.startsWith("//")){
            checkStringWithCustomSeparator();

            //커스텀 구분자를 정하기위한 문자열 부분을 없애줌
            inputString = inputString.substring(5);
        }

        //잘못된 문자열을 입력받았을 경우, 예외처리
        checkString();

        //구분자를 통일시킴
        inputString = inputString.replace(':', ',');
        if(customSeparator != null) {
            inputString = inputString.replace(customSeparator, ',');
        }

    }

    //덧셈 결과를 출력
    public void outputAdd(){
        //Calculations 클래스에서 add 함수 가져오기
        int result = calculation.Add(inputString);

        System.out.println("결과 : "+result);
    }



    //문자열 입력받기
    private void readString(){
        //문자열을 입력받음
        inputString = readLine();
    }

    //커스텀 구분자가 있는 문자열이 올바른 형식인지 확인
    private void checkStringWithCustomSeparator(){

        // 커스텀 구분자를 지정하기 위한 최소한의 문자열 길이
        if(this.inputString.length() < 5){

            throw new IllegalArgumentException("문자열 길이가 짧아서 커스텀 구분자를 지정할 수 없습니다.");

        }

        // 문자열이 //<구분자>\n 형식을 띄는지 확인
        if(this.inputString.charAt(3)!='\\' || this.inputString.charAt(4)!='\n'){

            throw new IllegalArgumentException("잘못된 커스텀 구분자 문자열 형식입니다.");

        }

        //구분자 지정
        customSeparator = inputString.charAt(2);

        //구분자가 숫자일 경우
        if(isNum(customSeparator)){
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }

    }

    private void checkString(){
        // 문자열의 모든 문자가 숫자 혹은 구분자인지 확인한 후, 아니라면 예외처리
        for(int i=0;i<inputString.length();i++){
            if(!isNum(inputString.charAt(i)) && !isSep(inputString.charAt(i))){
                throw new IllegalArgumentException("숫자, 구분자 이외 다른 문자가 있습니다.");
            }
        }
    }

    // 문자가 숫자에 해당하는지 판별
    private boolean isNum(char c){

        char[] numbs = {'0','1','2','3','4','5','6','7','8','9'};
        boolean ret = false;

        for(char num : numbs){
            if (c == num) {
                ret = true;
                break;
            }
        }

        return ret;
    }


    // 문자가 구분자인지 확인
    private boolean isSep(char c){

        if(c==','){
            return true;
        }

        if(c==';'){
            return true;
        }

        if(customSeparator!=null && c==customSeparator){
            return true;
        }

        return false;
    }

}
