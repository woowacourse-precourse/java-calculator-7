package calculator.service;

public class CalculatorService {
    public int calculate(String input){
        int totalSum = 0;
        String regex = ":|,";

        if(input.contains("//") && input.contains("\\n")){ // 커스텀 구분자가 있는 경우
            String custom = Character.toString
                    (input.charAt(input.indexOf("//")+2));

            if(custom.equals("\\"))
                custom = "\\\\";

            regex = regex + "|" + custom;
            input = input.substring(input.indexOf("\\n")+2);
        }

        String[] numbers = input.split(regex);
        for (String number : numbers) {
            totalSum += Integer.parseInt(number);
        }

        return totalSum;
    }
}
