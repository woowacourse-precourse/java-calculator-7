package calculator;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args){

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = readLine();
        String splitString = ",|:";

        if(input == null || input.isEmpty()){
            System.out.println("결과: "+0);
            return;
        }
        int sum=0;

        try{
            if(isCustom(input)){
                splitString += getCustom(input);
            }
            String[] tmp = input.split("\\\\n");
            input = tmp[tmp.length-1];


            String[] numArr = input.split(splitString);
            sum = calSum(numArr);
        }catch(IllegalArgumentException e){
            return ;
        }
        System.out.println("결과: "+sum);

    }

    public static int calSum(String[] numArr){
        int sum=0;
            for (String s : numArr) {
                if (!s.matches("[+-]?\\d*(\\.\\d+)?")) throw new IllegalArgumentException();
                if(Integer.parseInt(s)<=0){
                    System.out.println("minus");
                    throw new IllegalArgumentException();
                }
                sum += Integer.parseInt(s);
            }
        return sum;
    }

    public static boolean isCustom(String input){
        return input.startsWith("//");
    }

    public static String getCustom(String input){
        String customCommand="";
        String[] tmpStr = input.split("\\\\n");

        for(String s: tmpStr){
            if(isCustom(s)){
                String[] command = s.split("//");
                if(command.length==0) throw new IllegalArgumentException();
                customCommand += "|"+command[1];
            }
        }

        return customCommand;
    }
}
