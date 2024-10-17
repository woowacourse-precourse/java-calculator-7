package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

// 문자열 계산기 클래스
public class StringCalculator {

    String inputString = ""; // 입력받는 문자열
    Character customSeparator; // 커스텀 구분자

    //사용자로부터 문자열을 입력받음
    public void input(){

        //문자열 입력받기
        readString();
        //Todo: 잘못된 문자열을 입력받았을 경우, 예외처리
        //Todo: 커스텀 구분자가 있는 경우, 저장
    }

    //덧셈 결과를 출력
    public void outputAdd(){
        //Todo: Calculations 클래스에서 add 함수 가져오기
        //Todo: 결과 출력하기
    }


    //문자열 입력받기
    private void readString(){
        //문자열을 입력받음
        inputString = readLine();
    }

}