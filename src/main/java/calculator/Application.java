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

        else if(input.matches("\\d+")){
            return Integer.parseInt(input);
        } //하나의 숫자만 입력할 경우 그 숫자를 반환

        else if(input.startsWith("//")){
            int index = input.indexOf("\\n");
            String n = input.substring(2, index);
            input = input.substring(index+2);
            String[] numbers = input.split(n);

            int sum = 0;
            for(String number : numbers){
                sum+= Integer.parseInt(number);
            }
            return sum;
        } // 커스텀 구분자 지정

        String[] numbers = input.split("[,:]"); // 구분자로 문자열 분리

        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum; // 분리한 숫자를 합해 결과 출력
    }
}


    



