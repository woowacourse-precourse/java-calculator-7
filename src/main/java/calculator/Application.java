package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String delimiter = ",|:";
        String customDelimiter = "";

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if(!input.isEmpty()){
            String[] s = input.split("\\\\n");
            if(s.length>1){
                if(s[0].startsWith("//")){
                    customDelimiter = s[0].substring(2);
                    delimiter += "|"+customDelimiter;
                }else{
                    throw new IllegalArgumentException("커스텀 구분자를 사용하려면 //로 시작해야 합니다.");
                }
            }
            String[] inputNumbers = s[s.length-1].split(delimiter);
            int[] nums = new int[inputNumbers.length];

            try{
                for(int i = 0 ; i < nums.length ; i++){
                    nums[i] = Integer.parseInt(inputNumbers[i]);
                }
            }catch(Exception e) {
                throw new IllegalArgumentException("구분자 사이에 정상적인 숫자를 입력해야 합니다.");
            }
        }else{
            System.out.println("결과 : 0");
        }





    }
}
