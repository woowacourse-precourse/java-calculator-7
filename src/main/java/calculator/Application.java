package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    // TODO: 입력한 문자열에서 숫자를 추출하여 더하는 계산기

    // 1. 커스텀구분자 알아내기
    // 2. 커스텀구분자, 콜론, 쉼표로 구분하여 숫자 알아내고 배열에 저장
    // 3. 메인함수에서 2번 함수 호출하여 sum하고 출력


    //커스텀구분자를 알아내는 클래스(커스텀구분자가 만약 있다면)
    public void isDelimiter (String str) {
        //쉼표, 콜론, 커스텀구분자
        String customDelimiter = null; //커스텀 구분자
        float[] numbers=new float[0];

//        if (str.Startswith("//")) {
//
//        }
        

    }


    // 입력받은 문자열을 커스텀구분자, 콜론, 쉼표로 구분하여 숫자 알아내고 배열에 저장하는 클래스
    public static float isNumber(String str){
        // 만약 음의 숫자라면 에러처리
        //(1,2:3;4 5//67)
        //(//;\n1;2;3))
        //구분자로 숫자 구분 => sum에 더하기
        float num = 0;
        float sum = 0;

        sum += num;
        return sum;
    }
    
    public static void main(String[] args) {
//        쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
//        예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
//        앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.

//        사용자가 잘못된 값을 입력할 경우 ApplicationTest.java에서
//        IllegalArgumentException을 발생시킨 후 애플리케이션 종료
        //음의 숫자가 입력되었을 때

        //입력
        String enter = readLine(); //구분자와 숫자로 이루어진 문자열 입력받기


        //출력
        float result;

    }
}
