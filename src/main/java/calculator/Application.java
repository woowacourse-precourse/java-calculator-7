package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String str=Console.readLine();

        if(str.isEmpty()){
            System.out.println("결과 : 0");
            return;
        }

        String customSeparator=null;
        if(str.startsWith("//")){
            int end=str.indexOf("\\n");
            customSeparator=str.substring(0,end);

            str=str.substring(end+2);
        }

        String[] separator=customSeparator!=null?new String[]{",",":",customSeparator}:new String[]{",",";"};

        for(String s:separator){
            str=str.replace(s," ");
        }

        String[] integers=str.split(" ");

        int result=0;
        for(String s : integers){
            int i=Integer.parseInt(s);
            result+=i;
        }

        System.out.println("결과 : "+result);

    }
}
