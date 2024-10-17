package calculator;

import calculator.config.Configuration;
import calculator.controller.CalculatorController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final Configuration configuration = new Configuration();
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String s = Console.readLine();
        CalculatorController calculatorController = configuration.getCalculatorController();
        calculatorController.input(s);

//        Calculator c = new Calculator(s);
//        c.run();
    }
}

class Calculator {
    private String s;
    private String plusSeparator;

    public Calculator(String s) {
        this.s = s;
    }

    public void run(){
        boolean hasPlusSeparator = checkPlusSeparator();
        String[] separatedStringArr = separate(hasPlusSeparator);
        hasNaN(separatedStringArr);
        System.out.println("결과 : "+sum(separatedStringArr));
    }
    private boolean checkPlusSeparator() {
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
    private void hasNaN(String[] separatedStringArr){
        for(String s:separatedStringArr){
            for(char c:s.toCharArray()){
                if(c < 48 || c > 57)
                    throw new IllegalArgumentException();
            }
        }
    }
    private int sum(String[] separatedStringArr){
        int sum = 0;
        for(String separatedString:separatedStringArr){
            sum += Integer.parseInt(separatedString);
        }
        return sum;
    }
}
