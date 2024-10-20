package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        int sum = 0;
        Set<Character> set = new HashSet<>();
        set.add(':');
        set.add(',');
        if (input.charAt(0) == '/') { // 커스텀 구분자가 존재할 경우
            int st = 0;
            int tmp2 = 0;
            if (input.charAt(1) == '/') {
                boolean flag = false;
                int idx = 2;
                for (idx = 2; idx < input.length() - 1; idx++) {
                    if (input.charAt(idx) == '\\' && input.charAt(idx + 1) == 'n') {
                        flag = true;
                        st = idx;
                        break;
                    }
                }
                if (!flag) throw new IllegalArgumentException(); // //로 시작했는데 \n이 존재하지 않는 경우
                for (int i = 2; i < idx; i++) {
                    if (Character.isDigit(input.charAt(i))) throw new IllegalArgumentException(); // 구분자가 숫자인 경우
                    //if (Character.isAlphabetic(input.charAt(i))) throw new IllegalArgumentException(); // 구분자가 알파벳인 경우
                    set.add(input.charAt(i));
                }
            } else throw new IllegalArgumentException(); // /로 시작했는데 다음 문자가 /가 아닌 경우
            tmp2 = st;
            if (!set.contains('-')) {
                for (; st < input.length() - 1; st++) {
                    if (input.charAt(st) == '-' && Character.isDigit(input.charAt(st + 1)))
                        throw new IllegalArgumentException(); // 음수가 입력된 경우
                }
            }
            st = tmp2;
            StringBuilder tmp = new StringBuilder();
            for (; st < input.length(); st++) {
                char c = input.charAt(st);
                if (Character.isDigit(c)) {
                    tmp.append(c);
                } else if (set.contains(c)) {
                    if (tmp.length() > 0) {
                        sum += Integer.parseInt(tmp.toString());
                        tmp.setLength(0);
                    }
                }
            }
            if (tmp.length() > 0) {
                sum += Integer.parseInt(tmp.toString());
            }
            System.out.println("결과 : " + sum);
        }
        else { // 커스텀 구분자가 없을 때
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (Character.isDigit(c)) tmp.append(c);
                else if (set.contains(c)) {
                    if (tmp.length() > 0) {
                        sum += Integer.parseInt(tmp.toString());
                        tmp.setLength(0);
                    }
                }
                else throw new IllegalArgumentException(); // 구분자, 숫자가 아닌 다른 문자가 입력되었을 경우
            }
            if (tmp.length() > 0) {
                sum += Integer.parseInt(tmp.toString());
            }
            System.out.println("결과 : " + sum);
        }
    }
}
