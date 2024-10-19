package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public int addition(String[] strArr) throws IllegalArgumentException {
        int sum = 0;
        for(String number : strArr) {
            try {
                if(Integer.parseInt(number)<0) {
                    throw new IllegalArgumentException();
                } else {
                    sum += Integer.parseInt(number);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return  sum;
    }

    public int separate(String str) throws IllegalArgumentException {
        int answer = 0;
        String[] strArr = str.split(",|:");
        answer = addition(strArr);
        return  answer;
    }

    public int custom(String str) throws IllegalArgumentException {
        int answer = 0;
        int customIndex = str.indexOf("\\n");
        if(customIndex==-1) {
            throw new IllegalArgumentException();
        }
        String delimiter = str.substring(2,customIndex);
        String str2 = str.substring(customIndex+2);
        String[] strArr = str2.split(delimiter);
        answer = addition(strArr);
        return  answer;
    }

    public static void main(String[] args) {
        Application app = new Application();
        String str = Console.readLine();
        try {
            if(str.startsWith("//")) {
                System.out.println("결과 : " + app.custom(str));
            } else if(str.isEmpty()) {
                System.out.println("결과 : 0");
            } else {
                System.out.println("결과 : " + app.separate(str));
            }
        } catch (IllegalArgumentException e) {
            return;
        }
    }
}