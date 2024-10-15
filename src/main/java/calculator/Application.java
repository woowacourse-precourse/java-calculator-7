package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String s = Console.readLine();

        Calculator c = new Calculator(s);
        c.run();
    }
}

class Calculator {
    private String s;
    private String plusSeparator;

    public Calculator(String s) {
        this.s = s;
    }

    public void run(){
        System.out.println(checkPlusSeparator());
    }
    private boolean checkPlusSeparator() {
        //추가 구분자가 있으려면 문자열 길이가 최소 5글자는 넘어야 됨.
        //추가 구분자는 //로 시작함.
        // "//<추가 구분자>\n 이므로 3,4 번째가 \n 인지 확인 해야됨.
        // IF 추가 구문자까지만 있고 숫자가 없다면 어떡함??
        if (s.length() >= 5 && s.startsWith("//") && s.startsWith("\\n", 3)) {
            plusSeparator = String.valueOf(s.charAt(2));
            return true;
        }
        return false;
    }
}
