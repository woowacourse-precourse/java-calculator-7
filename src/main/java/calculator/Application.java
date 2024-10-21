package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // 입력 문구
        System.out.println("덧셈할 문자열을 입력해 주세요.");


        // 문자열 입력 받기
        String input = Console.readLine();
            //System.out.println("입력값 : " + input);


        // 구분자 변수에 기본 구분자 넣기
        String Sep = ",|:";
            //구분자 변수 테스트
            //System.out.println("기본구분자 : " + Sep);
        
        
        // 커스텀 구분자
        if (input.startsWith("//")){ // 문자열이 "//"로 시작되면 커스텀 구분자 설정으로 인지

            int end = input.indexOf("\\n"); //문자열에서 \n의 위치 찾기, 인덱스번호를 end에 삽입
                //end 확인
                //System.out.println("\\n의 위치 : " + end);

            if (end == -1) { //문자열에 \n 없으면 예외처리
                throw new IllegalArgumentException("구분자와 양수, 커스텀 구분자 설정 형식만 입력 가능합니다."); // 예외처리 output_message
            } else if (end == 2) {
                throw new IllegalArgumentException("커스텀 구분자가 입력되지 않았습니다."); // 예외처리 output_message
            }
            Sep += "|" + input.substring(2,end); // 구분자에 커스텀 구분자 포함시키기
                //구분자에 커스텀 구분자가 포함 되었는지 테스트
                //System.out.println("커스텀된 구분자 : " + Sep);

            input = input.substring(end + 2); // 나눈 문자열의 1번지 배열의 문자열을 input으로 지정
                //커스텀 구분자 처리 이후 input    
                //System.out.println("커스텀구분자처리 이후 입력값 : " + input);
            
        }


        // 숫자 추출
        // 구분자로 문자열을 분할하기
        String[] numbers = input.split(Sep);
            // 테스트 위해 구분된 숫자 출력
            /*
            for(String test_num : numbers){
                System.out.println("분할된 문자열 : " + test_num);
            }
            */
        

        // 더한 값 저장할 변수
        int sum = 0;

        //예외처리와 동시에 더하기
        for (String number : numbers){

            try{
                int num = Integer.parseInt(number); // 타입을 문자에서 숫자로 변환

                if (num < 0){ // 음수의 경우
                    throw new IllegalArgumentException("구분자와 양수, 커스텀 구분자 설정 형식만 입력 가능합니다."); // 예외처리 output_message
                }
                sum += num; // 덧셈
            } catch (NumberFormatException e) { // 숫자가 아닐 경우
                throw new IllegalArgumentException("구분자와 양수, 커스텀 구분자 설정 형식만 입력 가능합니다."); // 예외처리 output_message
            }
        }

        //결과 출력
        System.out.println("결과 : " + sum);
        
    }
}
