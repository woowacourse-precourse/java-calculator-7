package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = Console.readLine();
        ArrayList<String> seperator = new ArrayList<>();
        seperator.add(",");
        seperator.add(":");
        for (String s : seperator) {
            str = str.replaceAll(s, " ");
        }
        int sum = 0;
        if(!str.isEmpty()){
            String[] number = str.split(" ");
            for(String s : number){
                sum += Integer.parseInt(s);
            }
        }
        System.out.println(sum);
    }
}
