package calculator;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // 사용자 입력을 받음
        System.out.println(input);

        int sum = 0;
        String spliter = "[:|,]";

        if(input.startsWith("//")){
            input = input.replace("\\n", "\n");
            int ender = input.indexOf("\n");
            if(ender != -1){
                String newSpliter = input.substring(2, ender);
                spliter = spliter.replace("]", "") + "|" +  newSpliter + "]";
                input = input.substring(ender + 1);
            }
        }

        if(!(input.isEmpty())){
            String[] nums = input.split(spliter
            );
            for (String num : nums){
                sum += Integer.parseInt(num);
            }
        }
        System.out.println(sum);
    }
}