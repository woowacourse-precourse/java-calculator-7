package calculator;

public class Carculator {


    public static void sumNumbersFromLetters(String input){

        String[] tmp;

        String separator = "[,:;]";
        tmp = input.split(separator);

        System.out.println("결과 : " + sum(tmp));


    }

    public static int sum(String[] tokens){
        int total = 0;
        for(String token : tokens){
            total += Integer.parseInt(token.trim());
        }
        return total;
    }




}
