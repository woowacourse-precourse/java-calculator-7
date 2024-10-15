package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // //;\n1,2:3;4
        String delimiter = "[,:]";
        String customDelimiter = "";
        String input = Console.readLine();

        if(input.startsWith("//")){
            int delimiterEndIndex = input.indexOf("\\n");
            customDelimiter = input.substring(2,delimiterEndIndex);
            input = input.substring(delimiterEndIndex +2);
        }

        String regex = delimiter.substring(0,delimiter.length()-1)+customDelimiter+"]";
        System.out.println(regex);
        String[] numbers = input.split(regex);

        for (String number : numbers) {
            System.out.print(number);
        }


    }
}
