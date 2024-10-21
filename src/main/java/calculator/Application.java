package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public int addition(String[] strArr) throws IllegalArgumentException {
        int sum = 0;
        for(String number : strArr) {
            if(Integer.parseInt(number)<0) {
                throw new IllegalArgumentException();
            } else {
                sum += Integer.parseInt(number);
            }
        }
        return sum;
    }

    public int separate(String input) throws IllegalArgumentException {
        int answer = 0;
        String[] numArr = input.split(",|:");
        answer = addition(numArr);
        return answer;
    }

    public int custom(String input) throws IllegalArgumentException {
        int answer = 0;
        int customIndex = input.indexOf("\\n");
        if(customIndex==-1) {
            throw new IllegalArgumentException();
        }
        String delimiter = input.substring(2,customIndex);
        String target = input.substring(customIndex+2);
        String[] numArr = target.split(delimiter);
        answer = addition(numArr);
        return answer;
    }

    public static void main(String[] args) throws IllegalArgumentException {
        Application app = new Application();
        String input = Console.readLine();
        if(input.startsWith("//")) {
            System.out.println("결과 : " + app.custom(input));
        } else if(input.isEmpty()) {
            System.out.println("결과 : 0");
        } else {
            System.out.println("결과 : " + app.separate(input));
        }
    }
}