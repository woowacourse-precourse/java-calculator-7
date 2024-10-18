package calculator;

import java.util.Arrays;

public class StringCalculator {
    public static int add(String data){
        String[] split;
        if(isExistCustomDelim(data)) {
            split = data.replaceAll(Delimiter.CUSTOM_REPLACE.getRegex(), "") // 커스텀구분점 부분 제거
                        .split(getCustomDelim(data));
        }
        else {
            split = data.split(Delimiter.DEFAULT.getRegex());
        }

        int[] numbers = convertStringArrayToIntArray(split);

        return Arrays.stream(numbers).sum();
    }

    private static boolean isExistCustomDelim(String data){
        return data.matches(Delimiter.CUSTOM.getRegex());
    }

    private static String getCustomDelim(String data){
        return data.replaceAll(Delimiter.CUSTOM_DELIM.getRegex(), "");
    }

    private static int[] convertStringArrayToIntArray(String[] split) {
        int[] numbers = new int[split.length];
        for(int i = 0; i< split.length; i++) {
            // "" => 0
            if(split[i].isEmpty())
                numbers[i] = 0;
            else{
                try {
                    int num = Integer.parseInt(split[i]);
                    if (num >= 0) numbers[i] = num; // 양수일때만 베열에 저장
                    else throw new IllegalArgumentException();
                }catch (NumberFormatException e) {
                    throw new IllegalArgumentException();   // 입력 요구 사항에 맞지 않는 경우
                }
            }
        }
        return numbers;
    }
}