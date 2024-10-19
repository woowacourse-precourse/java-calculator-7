package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String strPlus= Console.readLine();
        String index;
        String[] splitStr;

        if(strPlus.startsWith("//")){
            strPlus= strPlus.substring(4);
            index=strPlus.substring(2,2);
            splitStr= strPlus.split(",|;");

//            for(int i=0; i<splitStr.length; i++){
//                if(splitStr[i].startsWith(index)){
//
//                }
//            }

        }else{
            splitStr= strPlus.split(",|;");
        }

        for (String s : splitStr) {
            System.out.println(s);
        }

        int answer=0;
        List<Integer> integerList=Arrays.stream(splitStr).map(value
                ->Integer.parseInt(value)).collect(Collectors.toList());


        for (Integer i : integerList) {
            answer+=i;
        }
        System.out.println(answer);
    }
}
