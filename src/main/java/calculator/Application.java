package calculator;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static int add(String input) {
        input = input.replace("\\n","\n");
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String defaultlimiter = ",|:";
        String arrnumbers = input;

        if(input.startsWith("//")){
            int EndlimieteIndex = input.indexOf("\n");
            if(EndlimieteIndex ==-1){
                throw new IllegalArgumentException("커스텀 구분자 지정 이후 줄바꿈이 필요");
            }
            defaultlimiter = Pattern.quote(input.substring(2,EndlimieteIndex));
            arrnumbers = input.substring(EndlimieteIndex+1);
        }
        String[] splitarrs = arrnumbers.split(defaultlimiter);
        int sumresult=0;

        for(String splitarr : splitarrs){
            try{
                splitarr = splitarr.trim();
                if(!splitarr.isEmpty()){
                    int num = Integer.parseInt(splitarr);
                    sumresult+=num;
                }
            }catch(NumberFormatException e){
                throw new IllegalArgumentException("유효하지 않은 숫자입니다");
            }
        } return sumresult;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //입력받은 String 배열을 쉼표 또는 세미콜론 기준으로 자르고 누적합을 계산
        try{
            System.out.println("덧셈할 문자열을 입력해주세요.");
            String inputstr = readLine();

            int result = add(inputstr);
            System.out.println("결과:"+ result);
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }
}