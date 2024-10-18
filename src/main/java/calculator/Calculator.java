package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
    private ArrayList<String> separator = new ArrayList<>(Arrays.asList(",", ":"));
    private String input;
    private int sum = 0;

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return this.input;
    }

    public ArrayList<String> getSeparator() {
        return this.separator;
    }

    public int getSum() {
        return this.sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String addSeparator(String str) throws IllegalArgumentException {

        while (str.length() > 0 && str.charAt(0) == '/') {
            if (str.length() >= 5 && str.charAt(1) == '/') { // 문자 길이로 애초에 양식 안맞고 길이 안맞는거 걸러서 indexing 오류 제거
                if (str.substring(2, 3).matches("[^a-zA-Z0-9\\\\\\\\s]")) { //특수 문자인지 확인
                    String sep = str.substring(2, 3);
                    str = str.substring(3);
                    if (str.startsWith("\\n")) {
                        str = str.substring(2);
                        this.separator.add(sep);
                    } else {
                        throw new IllegalArgumentException("잘못된 입력입니다. \\n이 없습니다.");
                    }
                } else {
                    throw new IllegalArgumentException("잘못된 입력입니다. 구분자가 없습니다.");
                }
                System.out.println(str);
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다. // 양식 혹은 길이가 맞지 않습니다.");
            }
        }

        System.out.println(str);
        return str;
    }

    public void manageAdd(String input) throws IllegalArgumentException {
        this.setInput(input);
        String stack = new String("");

        if (this.input.isEmpty()) {
            return;
        }
        this.addSeparator(this.input);
//        while (!this.input.isEmpty()) {
//            stack = stack.concat(this.input.substring(0, 1));
//            this.input = this.input.substring(1);
//            if (stack)
//        }
    }


}
