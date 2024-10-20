package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {

    static HashSet<Integer> delimiters = new HashSet<Integer>();

    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현
        var bf = new BufferedReader(new InputStreamReader(System.in));

        delimiters.add((int)':');
        delimiters.add((int)',');

        var result = 0;

        var now = bf.readLine();

        while (isCommand(now)) {
            break;
        }
    }

    static private boolean isCommand(String s) {
        if (s.charAt(0)=='/' && s.charAt(1)=='/') {
            return false;
        } else if (isNum(s.charAt(0)) || delimiters.contains((int)s.charAt(0))) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    static private boolean isNum(char c) {
        return '0'<=c && c<='9';
    }

    static private void addDelimiter(String s) {
        if (s.length()!=3) {
            throw new IllegalArgumentException();
        }

        int n = s.charAt(2);

        if (delimiters.contains(n)) {
            throw new IllegalArgumentException();
        }

        delimiters.add(n);
    }

    static List<String> extract(String s) {
        List<String> result = new ArrayList<>();

        int start = 0;

        for (int i=0; i<s.length(); i++) {
            int now = s.charAt(i);
            if (delimiters.contains(now)) {
                result.add(s.substring(start, i));
                start = i+1;
            } else if (!isNum(s.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }

        if (start != s.length()) {
            result.add(s.substring(start));
        }

        return result;
    }

    static String sum(List<String> nums) {
        List<Byte> arr = new ArrayList<>();

        arr.add((byte) 0);

        byte n = 0;
        for (String num: nums) {
            for (int i=num.length()-1; i>=0; i--) {
                int now = num.charAt(i)-'0';
                int idx = num.length()-1-i;

                if (arr.size()-1<idx) {
                    arr.add((byte) 0);
                }

                now+=arr.get(idx);
                now+=n;
                n=(byte) (now/10);
                arr.set(idx, (byte) (now%10));
            }
        }

        if (n==1) {
            arr.add((byte) 1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i=arr.size()-1; i>=0; i--) {
            sb.append(arr.get(i));
        }

        return sb.toString();
    }
}
