package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Application {
    public static void main(String[] args) {
        float result = 0;

        String input = Console.readLine();
        ArrayList <String> delimiters = new ArrayList<>(Arrays.asList(",",":"));

        Pattern pattern = Pattern.compile("//(.*?)\\n");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String delimiter = matcher.group(1);
            System.out.println(("구분자 추가"+delimiter));
            delimiters.add(delimiter);
        }

        System.out.println("최종구분자"+delimiters);

        for (String d : delimiters){
            input = input.replaceAll(Pattern.quote("//"+d+"q"),",");
        }
        System.out.println(input);

        String regex = String.join("|",delimiters);

        String arr[] = input.split(regex);
        System.out.println("arr:"+arr);
        for (String a : arr){
            result+= Float.parseFloat(a);
        }
        System.out.println(result);
    }
}