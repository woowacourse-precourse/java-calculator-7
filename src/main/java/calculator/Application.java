package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String sep="";
        String str = sc.nextLine();
        String [] newSep = str.split("");
        String[] newStr = new String[]{""};

        for (int i=2; i < newSep.length;i++){
            if (newSep[i].equals("\\") && newSep[i + 1].equals("n")) {
                break;
            }
            sep += newSep[i];
        }
        if(!sep.isEmpty()){
            newSep = str.split("[,:n"+sep+"]");
            newStr = newSep;
        }else{
            newStr = str.split("[,:]");
        }
        for (String s : newStr) {
            System.out.println(s);
        }
    }
}
