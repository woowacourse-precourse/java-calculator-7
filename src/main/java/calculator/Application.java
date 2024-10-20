package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        if(str.isEmpty()) {
            System.out.println(0);
            return;
        }
        String check = str.substring(0,2);
        int sum = 0;
        // 기본 구문
        String chr1[] = str.split(":|,");

        // 커스텀 구문
        if(check.equals("//")) {
            int dest = str.indexOf("\\n");
            if(dest != -1) {
                String custom_text = str.substring(2,dest);
                chr1 = str.substring(dest+2,str.length()).split(custom_text);
            }else {
                throw new IllegalArgumentException("시스템 종료.");
            }
        }

        for(String n : chr1) {
            if(Integer.parseInt(n) < 0) {
                throw new IllegalArgumentException("잘못된 값.");
            }
            sum += Integer.parseInt(n);
        }
        System.out.println("결과 : "+sum);
    }
}
