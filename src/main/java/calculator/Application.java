package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static String separator= "[,:]";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputString = readLine();

        if(inputString.isBlank()){
            if(inputString.isEmpty()){
                System.out.println("결과 : 0.0");
                return;
            }else{
                throw new IllegalArgumentException();
            }
        }

        try{
            separator = validateString(inputString);

            Double result = calculationString(separator,inputString);

            System.out.println("결과 : " + result);
        }catch (IllegalStateException err){
            return;
        }
    }

    public static String validateString(String input){
        try{
            checkCustom(input);
            return separator;
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    private static void checkCustom(String input){
        if(input.substring(0,2).equals("//") && input.contains("\\n")){
            int i = input.indexOf("\\");
            separator = "[";
            separator = separator + input.substring(2, i) + "]";
        }else if(!input.substring(0,2).equals("//") && !input.contains("\\n")){
            return;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public static Double calculationString(String separator, String input){

        Double sum=0.0;

        if(!separator.equals("[,:]")){
            int i = input.indexOf("\\");
            input = input.substring(i+2);
        }

        String[] split = input.split(separator);

        try{
            for(String temp : split){
                sum+=Double.parseDouble(temp);
            }
        } catch(NumberFormatException err){
            throw new IllegalArgumentException();
        }
        return sum;
    }
}
