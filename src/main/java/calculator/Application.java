package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Application {
    static String S;
    static ArrayList<String> arrayList;
    static HashSet<String> delimiters;
    static int ans = 0;

    static void sum() {
        for(String num : arrayList) {
            ans += Integer.parseInt(num);
        }
    }

    static void findNewDelimiter() {
        while(true) {
            int startIndex = S.indexOf("//");

            if(startIndex == -1) {
               break;
            }

            int endIndex = S.indexOf("\\n", startIndex);

            if(endIndex == -1) {
                throw new IllegalArgumentException();
            }

            String newDelimiter = S.substring(startIndex + 2, endIndex);
            delimiters.add(newDelimiter);

            S = S.substring(0, startIndex) + S.substring(endIndex + 2);
        }
    }

    static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    static void calculate() {
        findNewDelimiter();

        StringBuilder numberBuffer = new StringBuilder();

        for(int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);

            if(isNumber(currentChar)) {
                numberBuffer.append(currentChar);

                for(int j = i+1; j < S.length(); j++) {
                    if(!isNumber(S.charAt(j))) {
                        i = j-1;
                        break;
                    }

                    numberBuffer.append(S.charAt(j));
                }
                arrayList.add(numberBuffer.toString());
                numberBuffer.setLength(0);

            }
            else {
                numberBuffer.append(currentChar);

                for(int j = i+1; j < S.length(); j++) {
                    if(isNumber(S.charAt(j))) {
                        i = j-1;
                        break;
                    }

                    if(j == S.length()-1) {
                        throw new IllegalArgumentException();
                    }

                    numberBuffer.append(S.charAt(j));
                }

                if(!delimiters.contains(numberBuffer.toString())) {
                    throw new IllegalArgumentException();
                }

                numberBuffer.setLength(0);
            }
        }

        sum();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        arrayList = new ArrayList<>();
        delimiters = new HashSet<>();
        delimiters.add(",");
        delimiters.add(":");

        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        S = scanner.nextLine();

        try {
            calculate();
            System.out.println("결과 : " + ans);
        }
        catch(IllegalArgumentException e) {
            System.err.println(e);
        }
    }
}
