package calculator;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        //reader
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String numString = sc.next();

        //prcessor
        List<Character> sepList = new ArrayList<>();
        sepList.add(',');
        sepList.add(':');
        if(numString.contains("//")){
            sepList.add(numString.charAt(2));
            numString = numString.split("n")[1];
        }
        String newNumString=numString;
        for (Character c : sepList) {
            newNumString = newNumString.replace(c, '.');
        }

        String[] stringList = newNumString.split("\\.");
        Integer sum = 0;
        for (String s : stringList) {
            sum+=Integer.parseInt(s);
        }

        //writer
        System.out.print("결과 : ");
        System.out.println(sum);
    }
}
