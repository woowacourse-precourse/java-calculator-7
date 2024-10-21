package calculator;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //입력받은 String 배열을 쉼표 또는 세미콜론 기준으로 자르고 누적합을 계산
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String inputstr = readLine();
        int sumresult =0;

        //아무것도 입력하지 않으면 덧셈의 결과가 0
        if(inputstr.trim().isEmpty()){
            System.out.println("결과: "+ 0);
        } else{
            args = inputstr.split("[,:]");
            for(String arg:args){
                try{
                    if(!arg.trim().isEmpty()){ //입력받은 문자열이 공백요소가 아니라면
                        sumresult +=Integer.parseInt(arg.trim());
                    }
                }catch (NumberFormatException e){
                    System.out.println("잘못된 입력값입니다" + inputstr); //숫자,구분 연산자 외의 기호가 들어갔을때
                }
        }
            System.out.println("결과 : " + sumresult);
        }
    }
}
