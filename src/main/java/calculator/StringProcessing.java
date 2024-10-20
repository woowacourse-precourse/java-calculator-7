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


        if(!rawString.startsWith("//") || !rawString.startsWith("\\n", 3))
            throw new IllegalArgumentException("커스텀 구분자를 잘못 입력했습니다.");

        seperators.add(rawString.charAt(2)+"");

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
                    int number = Integer.parseInt(tempNumber.toString());
                    if (number < 0)
                        throw new IllegalArgumentException("숫자는 0보다 큰 수이어야 합니다. ");
                    numbers.add(number);
                    tempNumber.setLength(0);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("구분자 사이에는 숫자만 입력해야 합니다.");
                }
            }
            else
                tempNumber.append(rawString.charAt(i));
        }

        try{
            int number = Integer.parseInt(tempNumber.toString());
            if (number < 0)
                throw new IllegalArgumentException("숫자는 0보다 큰 수이어야 합니다. ");
            numbers.add(number);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("구분자 뒤에 숫자를 입력해야 합니다.");
        }

    }
}
