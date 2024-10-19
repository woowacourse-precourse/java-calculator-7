package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = Console.readLine();
        ArrayList<String> separator = new ArrayList<>();
        separator.add(",");
        separator.add(":");
        if(str.startsWith("//") && str.charAt(3)=='\\' && str.charAt(4) == 'n'){
            separator.add(str.substring(2,3));
            str = str.substring(5);
        }
        for (String s : separator) {
            str = str.replaceAll(s, " ");
        }
        int sum = 0;
        if(!str.isEmpty()){
            String[] number = str.split(" ");
            for(String s : number){
                sum += Integer.parseInt(s);
            }
        }
        System.out.println("결과 : " + sum);
    }
}
