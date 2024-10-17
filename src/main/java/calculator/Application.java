package calculator;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Application app = new Application();
        String input = Console.readLine();
        int result = app.add(input);
        System.out.println("결과 : " + result);

    }

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String separator = ",|:";
        if(numbers.startsWith("//")){
            int newLineIndex = numbers.indexOf('\n');
            if(newLineIndex != -1){
                String customSeparator = numbers.substring(2,newLineIndex);
                separator = customSeparator + separator;
                numbers = numbers.substring(newLineIndex + 1);
            }
        }
        String[] numList = splitNumbers(numbers,separator);
        return sum(numList);

    }
    public String[] splitNumbers(String numbers, String divider){
        return numbers.split(divider);
    }

    public int convertToInt(String num){
            return Integer.parseInt(num.trim());
    }

    public int sum(String[] numbers){
        int total = 0;
        StringBuilder negativeNumbers = new StringBuilder();

        for (String number : numbers){
            int num = convertToInt(number);
            if(num < 0){
                negativeNumbers.append(num).append(" ");
            }else if(num <1000){
                total += num;
            }
        }
        if (negativeNumbers.length() > 0){
            throw new IllegalArgumentException("Negative not allowed: " + negativeNumbers);
        }
        return total;
    }
}



