package calculator;


import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static String sep = "\\,|\\:";

    public static int add_arrays(int[] nums){

        int result = 0;
        for (int num : nums) {
            result += num;
        }

        return result;
    }

    public static boolean is_num(String str){
        for(int i = 0; i<str.length(); i++){
            int num = (int) str.charAt(i);
            if(num < 48 || num > 57){
                return false;
            }
        }

        return true;
    }

    public static int[] parsing_string(String str){
        // str은 숫자 구분자 숫자 구분자... 형식임을 가정한다

        String[] spe_result = str.split(sep);

        int[] result = new int[spe_result.length];

        for(int i = 0; i<spe_result.length; i++){
            if(is_num(spe_result[i])){
                // 숫자 -> parsing 잘된것!
                result[i] = Integer.parseInt(spe_result[i]);
            }else{
                throw new IllegalArgumentException("이상하오...");
            }
        }
        return result;
    }

    public static String set_custom(String str){

        String[] strs = str.split("\\\\n");
        for(int i = 0; i<strs.length; i++){
            if(strs[i].charAt(0) == '/'){
                // 커스텀 구분자 지정일것
                if(strs[i].length() == 3){
                    if(strs[i].charAt(1) == '/') {
                        sep += ("|" + strs[i].charAt(2));
                        continue;
                    }
                }
                // 길이가 3이 아니란건
                // //문자열 <- 형식을 지키지 않았다는것!
                throw new IllegalArgumentException("이상하오...");
            }else{
                // 커스텀 구분자는 아님!
                return strs[i];
            }
        }

        return "";
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현



        String inputtext = readLine();

        String strnums = set_custom(inputtext);

        int[] nums = parsing_string(strnums);

        System.out.println("결과 : " + add_arrays(nums));

    }
}
