package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

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
        //hasPlusSeparator:추가 구분자가 있는가?
        boolean hasPlusSeparator = checkPlusSeparator();
        System.out.println(hasPlusSeparator);
        //List 형태로 숫자가 분해된 것을 확인함.
        String[] separatedStringArr = separate(hasPlusSeparator);
        System.out.println(Arrays.stream(separatedStringArr).toList());
        //숫자가 아닌 것이 남아 있는지 확인. 여기서 통과 여부는 throw 가 안되면 통과임.
        hasNaN(separatedStringArr);

    }
    private boolean checkPlusSeparator() {
        //추가 구분자가 있으려면 문자열 길이가 최소 5글자는 넘어야 됨.
        //추가 구분자는 //로 시작함.
        // "//<추가 구분자>\n 이므로 3,4 번째가 \n 인지 확인 해야됨.
        //끝났으면 추가 구분자를 확인하는 부분을 제거한 문자열로 바꿈.
        // IF 추가 구분자까지만 있고 숫자가 없다면 어떡함??
        if (s.length() >= 5 && s.startsWith("//") && s.startsWith("\\n", 3)) {
            plusSeparator = String.valueOf(s.charAt(2));
            s = s.substring(5);
            return true;
        }
        return false;
    }
    private String[] separate(boolean hasPlusSeparator){
        if(!hasPlusSeparator){
            return s.split("[:,]");
        }else{
            if(plusSeparator.equals("\\"))
                return s.split("[:,"+plusSeparator.repeat(2)+"]");
            return s.split("[:,"+plusSeparator+"]");
        }
    }
    //숫자가 아닌 문자를 발견할 경우 throw new IllegalArgumentException(); 해버림
    private void hasNaN(String[] separatedStringArr){
        for(String s:separatedStringArr){
            for(char c:s.toCharArray()){
                if(c < 48 || c > 57)
                    throw new IllegalArgumentException();
            }
        }
    }
}
