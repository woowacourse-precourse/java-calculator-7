package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

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

    static private boolean isCommand(String s) throws IllegalArgumentException {
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
}
