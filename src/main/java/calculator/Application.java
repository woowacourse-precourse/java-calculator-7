package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력 문구
        System.out.println("덧셈할 문자열을 입력해 주세요.");


        // 문자열 입력 받기
        String input = Console.readLine();
        

        // 구분자 변수에 기본 구분자 넣기
        String Sep = ",|:";
            //구분자 변수 테스트
            //System.out.println("기본구분자 : " + Sep);
        
        
        // 커스텀 구분자
        // 문자열이 "//"로 시작되면 커스텀 구분자 설정으로 인지
        if (input.startsWith("//")){
            String[] division = input.split("\n",2); // \n을 기준으로 문자열을 2개로 분할
                // 분할된 input 테스트
                //System.out.println("분할0번지 : " + division[0]);
                //System.out.println("분할1번지 : " + division[1]);
            String customSep = division[0].substring(2); // 나눈 문자열의 0번지 배열의 문자열에서 "//"제거 후 커스텀 구분자로 지정
            Sep += "|";
            Sep += customSep; // 구분자에 커스텀 구분자 포함시키기
                // 구분자에 커스텀 구분자가 포함 되었는지 테스트
                //System.out.println("구분자 : " + Sep);
            input = division[1]; // 나눈 문자열의 1번지 배열의 문자열을 input으로 지정
        }


        // 숫자 추출
        // 기본 구분자와 숫자 구분하여 숫자만 문자열 배열에 넣기
        String[] numbers = input.split(Sep);
            // 테스트 위해 구분된 숫자 출력
            /*
            for(String test_num : numbers){
                System.out.println("구분된 숫자 : " + test_num);
            }
            */
        

        // 더하기
        int sum = 0; // 더한 값 저장할 변수

        for (String number : numbers){
            int num = Integer.parseInt(number); // 타입을 문자에서 숫자로 변환
            sum += num; // 덧셈
        }

        //결과 출력
        System.out.println("결과 : " + sum);
        

    }
}
