package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    // TODO: 입력한 문자열에서 숫자를 추출하여 더하는 계산기

    // 1. 커스텀구분자 알아내기
    // 2. 커스텀구분자, 콜론, 쉼표로 구분하여 숫자 알아내고 배열에 저장
    // 3. 메인함수에서 2번 함수의 배열 호출하여 sum하고 출력
    
    public static void main(String[] args) {
        float[] numbers=new float[0];
        float result=0;

        //입력
        String enter = readLine();
        
        //함수들 호출 후 return된 배열을 numbers배열에 저장하기


        //배열에 저장된 숫자 합산

        //출력
        System.out.println("결과 : "+result);

    }
}
