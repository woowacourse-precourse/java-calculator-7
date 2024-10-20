package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class StringProcessing {
    private static ArrayList<String> seperators = new ArrayList<>(Arrays.asList(",",":"));
    private static ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0));

    static ArrayList<Integer> processString(String rawString){
        int startIdx = 0;
        // 커스텀 구분자 추가
        if (rawString.startsWith("//")) {
            startIdx = 5;
            findCustomSeperator(rawString);
        }

        //숫자 추출
        extractNumber(rawString.substring(startIdx));

        return numbers;
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
            throw new IllegalArgumentException("커스텀 구분자는 //와 \\n사이에 위치해야 합니다.");
        seperators.add(tempSeperator.toString());

    }

    private static void extractNumber(String rawString) {
        String key = seperators.getFirst();
        //구분자 통일
        for (String seperator : seperators)
            rawString = rawString.replaceAll(seperator, key);

        //숫자 추출
        StringBuilder tempNumber = new StringBuilder();
        for(int i = 0; i < rawString.length(); i++){
            if (Character.toString(rawString.charAt(i)).equals(key)) {
                try {
                    numbers.add(Integer.parseInt(tempNumber.toString()));
                    tempNumber.setLength(0);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("구분자 사이에는 숫자만 입력해야 합니다.");
                }
            }
            else
                tempNumber.append(rawString.charAt(i));
        }

    }
}
