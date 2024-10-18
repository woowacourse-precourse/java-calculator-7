package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        Console.close();

    }

    public static long splitString(String str) {
        if(str.isEmpty()){
            return 0;
        }

        String separator = "[,:]";

        if (str.startsWith("//")) {
            int endIndex = str.indexOf("\\n");
            if (endIndex == -1) {
                throw new IllegalArgumentException();
            }
            separator = str.substring(2, endIndex);
            str = str.substring(endIndex + 2);
        }

        String[] numList = str.split(separator);

        return calculate(numList);
    }

    public static long calculate(String[] numList){
        long sum = 0;

        for (String s : numList) {
            sum += parseLong(s);
        }
        return sum;
    }

    public static long parseLong(String str){
        try{
            long num = Long.parseLong(str);
            if(num <= 0){
                throw new IllegalArgumentException();
            }
            return num;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

}
