package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {


    public static void run(String input){

        if (input == null || input.isEmpty() || input.isBlank()) {
            System.out.println("결과 : 0");
            return;
        }


        String[] tmp;

        if(input.startsWith("//")){
            String customSeparator = findCustomSeparator(input);
            String letters = input.substring(5);
            if (letters.length() == 1) {
                System.out.println("결과 : " + letters);
                return;
            }
            assert customSeparator != null;
            tmp = letters.split(customSeparator);
        }else{

            String separator = "[,:;]";
            tmp = input.split(separator);
        }



        System.out.println("결과 : " + sum(tmp));


    }

    private static int sum(String[] tokens){
        int total = 0;
        for(String token : tokens){
            String trimmedToken = token.trim();
            int value = Integer.parseInt(trimmedToken);
            if (value < 0) {
                throw new IllegalArgumentException("ERROR : 음수는 허용되지 않습니다." + value);
            }
            total += value;
        }
        return total;
    }
    

    private static String findCustomSeparator(String input){
        input = input.replace("\\n", "\n"); // \\n을 실제 줄바꿈 \n으로 변환
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            String separator = matcher.group(1);
            // 정규 표현식 메타문자를 이스케이프 처리
            if ("?*+[](){}^$|.".contains(separator)) {
                // 두 번의 백슬래시 사용, split을 위해선 메타문자 앞에 역슬래쉬 2개 \\ 를 붙이는 이스케이프처리가 필요.
                separator = "\\" + separator;
            }
            return separator;
        }
        return null;
    }




}
