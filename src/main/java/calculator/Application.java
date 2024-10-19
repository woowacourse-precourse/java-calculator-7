package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int add(String str, String delimiter){
        int a = 0;
        String[] strArr = str.split(delimiter);

        for (String number : strArr) {
            try {
                int i = Integer.parseInt(number);
                if (i > 0) {
                    a += i;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return a;
    }

    public static int summarize(String str){
        int ans = 0;
        if (!str.isEmpty()) {
            if(!Character.isDigit(str.charAt(str.length() - 1))){
                throw new IllegalArgumentException();
            }
            if (str.matches("//(.*?)\\\\n.*")) {
                String newlyAddedDelimiter = str.replaceAll("//(.*?)\\\\n.*","$1");
                String strRule;
                if(newlyAddedDelimiter.length() == 0)
                {
                    strRule = ",|:";
                }
                else{
                    strRule = newlyAddedDelimiter + "|,|:";
                }
                str = str.replaceAll("//(.*?)\\\\n","");
                ans = add(str, strRule);
            }
            else if(Character.isDigit(str.charAt(0))){
                ans = add(str, ",|:");
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해주세요.");

        String str = camp.nextstep.edu.missionutils.Console.readLine();

        int ans = 0;
        ans = summarize(str);
        System.out.println("결과 : " + ans);
    }
}