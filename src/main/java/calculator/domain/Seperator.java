package calculator.domain;


import java.util.Arrays;
import java.util.stream.Stream;

public class Seperator {
    static String CUSTOM_SEPERATORS=",|:";

    public static void add(String customSeperator){
        CUSTOM_SEPERATORS=CUSTOM_SEPERATORS+"|"+customSeperator;
    }

    public static int calculate(String input){
         input=makeToPure(input);

        int result=0;
        String[] numbers=input.split(CUSTOM_SEPERATORS);

        for (String number:numbers){
           int num=Integer.parseInt(number);
           result+=num;
        }

        return result;
    }

    //임시로 public
    public static String makeToPure(String input) {
        // // \n으로 시작한다면
        if (input.charAt(0)=='/') {
            input= input.split("^//(.)\\\\n{1}")[1];
        }


        return input;
    }


}
