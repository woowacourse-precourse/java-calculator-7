package calculator;
import  java.util.Scanner;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) { //main 메서드 : Scanner객체 호출 후 문자열 입력
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();
        int result = calculator(input); //calculator함수 호출
        System.out.println("결과 : " + result);
        scanner.close();

    }

    public static int calculator(String input) {
        if (input.isEmpty()) {// 비어있을 때 0 리턴
            return 0;
        }
        String delimiter = ",:"; //기본 구분자 지정
        if (input.startsWith("//")) {// //와 \n 사이의 문자열을 costom 구분자로 지정
            int delimiterIndex = input.indexOf("\\n");
            for (int i = 2; i < delimiterIndex; i++) { //구분자가 2개일 시에도 작동하도록 함
                delimiter += input.charAt(i);// 기본구분자에 costom 구분자 추가
            }
            input = input.substring(delimiterIndex + 2);//costom 구분자 설정 문자열 삭제
        }
        StringTokenizer tokenizer = new StringTokenizer(input,delimiter); //StringTokenizer로 token 분리
        int sum = 0;
        while (tokenizer.hasMoreTokens()) {//while문을 사용하여 토큰끼리 합함
            String token = tokenizer.nextToken();
            try {
                sum += Integer.parseInt(token);

        }  catch(NumberFormatException e){//try catch문을 통해 IllegalArgumentException를 발생
            throw new IllegalArgumentException("잘못된 입력입니다. :" + token);//thorw하여 프로그램 종료
        }
    }
        return  sum; //숫자들의 합 리턴
    }
}

