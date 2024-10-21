package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
    	
    	System.out.println("덧셈할 문자열을 입력해 주세요: ");

        String input = Console.readLine();

        StringCalculator calculator = new StringCalculator();

        int result = calculator.add(input);
        System.out.println("결과 : " + result);
    }
}

class StringCalculator{
    public int add(String input){
        if(input.isEmpty()){
            return 0;
        } //빈 문자열을 입력할 경우 0 반환

        else if(input.matches("-?\\d+")){
            int num = Integer.parseInt(input);

            checkNum(num);

            return num;
        } //하나의 숫자만 입력할 경우 그 숫자를 반환

        else if(input.startsWith("//")){
            int index = input.indexOf("\\n");
            String n = input.substring(2, index);
            input = input.substring(index+2);
            String[] numbers = input.split(Pattern.quote(n) + "|," + "|:");

            int sum = 0;
            for(String number : numbers){
                int num = Integer.parseInt(number);

                checkNum(num);

                sum+= num;
            }
            return sum;
        } // 커스텀 구분자 지정

        throw new IllegalArgumentException("입력이 잘못되었습니다.");
    }

    private void checkNum(int num){
        if(num<0){
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }
}


    



