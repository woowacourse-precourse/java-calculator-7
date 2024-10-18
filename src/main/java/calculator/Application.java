package calculator;
import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String a = readLine();
        System.out.println("결과 : "+ Calculator(a));

    }


    public static int Calculator(String str){
        int sum = 0;
        String[] s = {"",""};
        String separator = "[,:]";
        if(str.isEmpty()){
            return 0;
        }

        String[] x = str.split(separator);
        for (String string : x) {
            int z = Integer.parseInt(string);
            sum += z;
        }
        return sum;
    }
}
