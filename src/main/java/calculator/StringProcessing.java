package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class StringProcessing {
    private static ArrayList<String> seperators = new ArrayList<>(Arrays.asList(",",":"));
    private static ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0));
    static String processString(String rawString){

        // 커스텀 구분자 추가
        if (rawString.startsWith("//"))
            findCustomSeperator(rawString);

        System.out.println(seperators);
        return "";
    }


    private static void findCustomSeperator(String rawString) {
        StringBuilder tempSeperator= new StringBuilder();
        boolean isFind = false;
        for(int i = 2; i < rawString.length()-2; i++){
            if (rawString.substring(i, i+2).equals("\\n")) {
                isFind = true;
                break;
            }
            tempSeperator.append(rawString.charAt(i));
        }
        if (!isFind)
            throw new IllegalArgumentException("커스텀 구분자는 \\n으로 끝나야 합니다.");
        seperators.add(tempSeperator.toString());

    }
}
