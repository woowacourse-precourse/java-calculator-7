package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        HashSet<Integer> delimiters = new HashSet<Integer>();
        int idx = 0;

        delimiters.add((int)':');
        delimiters.add((int)',');

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String line = Console.readLine();

        if (Objects.isNull(line)) {
            System.out.println("결과 : 0");
            return;
        }

        String now = getCommand(line, idx);
        if (Objects.nonNull(now)) {
            idx+=now.length()+2;
        }

        while (Objects.nonNull(now) && isCommand(now, delimiters)) {
            addDelimiter(now, delimiters);
            now = getCommand(line, idx);
            if (Objects.nonNull(now)) {
                idx+=now.length()+2;
            }
        }

        if (idx < line.length()) {
            throw new IllegalArgumentException();
        }

        if (Objects.isNull(now)) {
            now = "";
        }

        List<String> nums = extract(now, delimiters);

        var result = sum(nums);

        System.out.println("결과 : " + result);
    }

    static private String getCommand(String s, int idx) {
        for (int i=idx; i<s.length()-1; i++) {
            if (s.charAt(i)=='\\' && s.charAt(i+1)=='n') {
                String result = s.substring(idx, i);
                idx = i+2;
                return result;
            }
        }
        if (idx<s.length()) {
            String result = s.substring(idx);
            idx = s.length();
            return result;
        } else {
            return null;
        }
    }

    static private boolean isCommand(String s, HashSet<Integer> delimiters) {
        if (s.isEmpty()) {
            return false;
        } else if (s.charAt(0)=='/' && s.charAt(1)=='/') {
            return true;
        } else if (isNum(s.charAt(0)) || delimiters.contains((int)s.charAt(0))) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    static private boolean isNum(char c) {
        return '0'<=c && c<='9';
    }

    static private void addDelimiter(String s, HashSet<Integer> delimiters) {
        if (s.length()!=3) {
            throw new IllegalArgumentException();
        }

        int n = s.charAt(2);

        if (delimiters.contains(n)) {
            throw new IllegalArgumentException();
        }

        delimiters.add(n);
    }

    static List<String> extract(String s, HashSet<Integer> delimiters) {
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
