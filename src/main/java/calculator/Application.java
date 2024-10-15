package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Application {
    static String S;
    static ArrayList<String> arrayList;
    static HashSet<String> hashSet;
    static int ans = 0;

    static void sum() {
        for(int i = 0; i < arrayList.size(); i++) {
            ans += Integer.parseInt(arrayList.get(i));
        }
    }

    static void findNewDelimiter() {
        while(true) {
            int startIndex = S.indexOf("//");

            if(startIndex == -1) {
                break;
            }
            int endIndex = S.indexOf("\n", startIndex);

            if(endIndex == -1) {
                throw new IllegalArgumentException();
            }

            String s = S.substring(startIndex+2, endIndex);
            hashSet.add(s);

            S = S.substring(0, startIndex) + S.substring(endIndex+1);
        }
    }

    static boolean isNumber(char num) {
        if(num >= '0' && num <= '9') {
            return true;
        }

        return false;
    }

    static void calculate() {
        findNewDelimiter();

        for(int i = 0; i < S.length(); i++) {
            String pre = String.valueOf(S.charAt(i));
            if(isNumber(S.charAt(i))) {
                for(int j = i+1; j < S.length(); j++) {
                    if(!isNumber(S.charAt(j))) {
                        i = j-1;
                        break;
                    }

                    pre += String.valueOf(S.charAt(j));
                }
                arrayList.add(pre);
            }
            else {
                for(int j = i+1; j < S.length(); j++) {
                    if(isNumber(S.charAt(j))) {
                        i = j-1;
                        break;
                    }

                    if(j == S.length()-1) {
                        throw new IllegalArgumentException();
                    }

                    pre += String.valueOf(S.charAt(j));
                }

                if(!hashSet.contains(pre)) {
                    throw new IllegalArgumentException();
                }
            }
        }

        sum();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        hashSet = new HashSet<>();
        hashSet.add(",");
        hashSet.add(":");

        Scanner scanner = new Scanner(System.in);
        S = scanner.next();

        try {
            calculate();
            System.out.println("결과 : " + ans);
        }
        catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}
