package calculator;
import camp.nextstep.edu.missionutils.Console;


public class Application {

    public int add(String str){
        int sum =0;
        String delimiter = ",:";

        if (str==null || str.isEmpty()){ //값이 비어있으면 0반환
            return sum;
        }

        if (str.startsWith("//")){ //구분자에 //와\n 사이 위치한 문자도 포함하기
            int index = str.indexOf("\n");
            if (index==-1) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
            delimiter = str.substring(2, index); //구분자 덮어쓰기
            str = str.substring(index+1); //숫자열 추출
        }


        return sum;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
    }
}
