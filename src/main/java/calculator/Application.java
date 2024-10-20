package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String str = input.trim();
        if(str.isEmpty()) {
            System.out.println(0);
            return;
        }
        String check = str.substring(0,2);
        int sum = 0;

        // 기본 구분자
        String chr1[] = str.split(":|,");

        // 커스텀 구분자
        if(check.equals("//")) {
            int dest = str.indexOf("\\n");
            if(dest == 2){
                throw new IllegalArgumentException("invild error");
            }
            if(dest != -1) {
                String custom_text = str.substring(2,dest);
                chr1 = str.substring(dest+2,str.length()).split(custom_text);
            }else {
                throw new IllegalArgumentException("invaild error");
            }
        }

        for(String n : chr1) {
            if(n.isEmpty()){
                continue;
            }
            if(Integer.parseInt(n) < 0) {
                throw new IllegalArgumentException("invaild error");
            }
            sum += Integer.parseInt(n);
        }
        System.out.println("결과 : "+sum);
    }
}
