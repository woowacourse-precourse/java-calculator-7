package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        StringBuilder separator = new StringBuilder();    //입력받은 문자열에 커스텀 구분자가 있는지
        String[] result;    //문자열 배열 선언
        int total = 0;    //후에 총 합 값 출력을 위한 저장 변수 선언

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();    //주어진 Console API를 통해 문자열 입력받음

        try{
            //커스텀 구분자에 대한 처리
            if(userInput.startsWith("//")) {
                int idx = userInput.indexOf("\\n");   //커스텀 구분자 확인을 위해

                if (idx == -1) {
                    //커스텀 구분자 형식이 잘못 된 경우
                    throw new IllegalArgumentException();
                }else{
                    //커스텀 구분자, 기본 구분자에 대한 처리
                    separator.append(userInput.substring(2, idx));  //커스텀 구분자 추출하는 코드

                    //그 후 원본 문자열에서 앞선 커스텀 구분자 관련 글 처리
                    userInput = userInput.substring(idx + 2);
                    result = userInput.split(",|;|" + separator);
                }
            }else if(userInput.length() == 0){
                //공백인 경우
                total = 0;

            }else if(!Character.isDigit(userInput.charAt(0))){
                //문자열이 숫자로 시작하지 않는 경우(잘못된 입력)
                throw new IllegalArgumentException();

            } else{
                //기본 구분자 사용
                result = userInput.split(",|:");
            }


        } catch (IllegalArgumentException e){    //System.exit 통해 프로그램 종료를 하지 않기 위해 try~catch문으로 예외 잡기
            Console.close();   //에러가 발생한 경우 Console API에서 close 호출 후
            return;    //return문을 통해 종료
        }
        Console.close();
        return;
    }
}
