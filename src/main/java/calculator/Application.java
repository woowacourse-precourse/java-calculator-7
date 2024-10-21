package calculator;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        //reader
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String numString = sc.next();

        try {
            //writer
            System.out.println("결과 : " + processor(numString));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Integer processor(String numString){
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

        return sum;
    }
}
