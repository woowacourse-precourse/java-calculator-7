package calculator;


import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static String sep = ",|:";

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

    public static void main(String[] args) {
        // TODO: 프로그램 구현



        String inputtext = readLine();
        int[] nums = parsing_string(inputtext);

        System.out.println(add_arrays(nums));

    }
}
