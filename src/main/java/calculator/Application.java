package calculator;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
    	
    	System.out.println("put the number: ");

        String input = Console.readLine();

        StringCalculator calculator = new StringCalculator();

        int result = calculator.add(input);
        System.out.println("answer : " + result);
    }

}

class StringCalculator{
    public int add(String input){
        if(input.isEmpty()){
            return 0;
        } //빈 문자열을 입력할 경우 0 반환
        return -1;
    }
}


    



