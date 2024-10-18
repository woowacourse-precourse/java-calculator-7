package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static char[] customArray  = new char[10];

    /* 커스텀 문자가 있는지 확인하고, 만약 커스텀문자열이라면 커스텀문자열을 배열로 저장*/
    private static boolean isCustom(String str) {

        if(str.charAt(0) == '/' && str.charAt(1)=='/'){
            for(int i=2; i<str.length(); i++) {
                if(str.charAt(i-1) == '\\' && str.charAt(i)=='n') {
                    for(int j=0; j<i-3; j++) {
                       //  System.out.println("j:"+j+" i:"+(i-2)+" "+str.charAt(j));
                        customArray[j] = str.charAt(j+2);
                    }
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현

    /* 이렇게 입력을 받고... 처리하면 되는구나 */

        String str = Console.readLine();

        if(isCustom(str)){
            System.out.print(isCustom(str));
            System.out.print(customArray);


        } else {

        //    System.out.print("false");

            System.out.print(isCustom(str));

        }



    }


}
