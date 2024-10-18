package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    public void run() {
        //입력받기
        String str = getString();
        int sum = 0;
        if (custom(str)) { //커스텀 구분자
            String a = ConvertSep(String.valueOf(str.charAt(2)));
            String sep = "[,:" + a + "]";
            str = str.substring(5);
            //구분자이면 구분자를 sep에 추가하고 계산할 값 잘라줌
            sum = getSum(str, sep);
        } else {
            String sep = "[,:]"; //구분자 아니면 구분자[,:]로!
            sum = getSum(str, sep);
        }
        System.out.println("결과 : " + sum);
        System.out.println("sss");
        System.out.println("ddd");
    }

    // 구분자가 [, \, ] 인 경우 구분자 조정  
    private static String ConvertSep(String a) {
        if (a.equals("\\")) {
            a = "\\\\";
        } else if (a.equals("[")) {
            a = "\\[";
        } else if (a.equals("]")) {
            a = "\\]";
        }
        return a;
    }

    //사용자의 입력을 받는 메서드
    private static String getString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        return str;
    }

    //합 구하기!
    private static int getSum(String str, String sep) {
        int sum = 0;
        String[] splitArray = str.split(sep);
        //구분자로 문자열을 나눈뒤 각 문자열에서 0~9 숫자 외의 문자가 발견되면 예외 던짐
        for (String s : splitArray) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (48 < c && c > 57) { //0-9 숫자 아닌 문자열은 예외처리
                    throw new IllegalArgumentException();
                }
            }
            int num;
            try {
                num = Integer.valueOf(s); //문자열이면... 예외처리!
            } catch (NumberFormatException e) {
                //:21 같은 경우 num이 null값이 되기 때문에 0으로
                num = 0;
            }
            if (num < 0) { //음수인 경우 예외처리
                throw new IllegalArgumentException();
            }
            sum += num;
        }
        return sum;
    }

    //커스텀 문자열인지 확인 
    private boolean custom(String str) {
        if (str.length() <= 1) {
            return false;
        }
        String a = "";
        if (str.substring(0, 2).equals("//") && str.substring(3, 5).equals("\\n")) {
            a = String.valueOf(str.charAt(2));
            return true;
        } else {
            return false;
        }
    }


}
