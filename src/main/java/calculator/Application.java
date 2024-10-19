package calculator;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String userInput = Console.readLine();
        String [] input = userInput.split("[,/]");

        int num = 0;
        for(int i =0; i<input.length; i++){
            System.out.println(input[i]);

            //input[i] 공백 처리;
            if(!input[i].isEmpty()){
                num += Integer.parseInt(input[i]);

            }
        }
        System.out.println(num);
    }
}
