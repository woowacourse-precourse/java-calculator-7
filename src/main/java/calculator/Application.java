package calculator;

import java.io.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static String line;
    static String[] lines;
    static String[] ansLine1;
    static String[] ansLine2;
    static String newLine;
    static String custom;
    static boolean isCus;
    static int ans;
    static int x;

    static void init() {
        line = "";
        lines = new String[] {};
        ansLine1 = new String[] {};
        ansLine2 = new String[] {};
        newLine = "";
        custom = "";
        isCus = false;
        ans = 0;
        x = 2;
    }
    static void chkCus() { // 커스텀 구분자 추가
        if (lines[0].equals("/") && lines[1].equals("/")) {
            while (x < lines.length-1) {
                if (lines[x].equals("\\") && lines[x+1].equals("n")) {
                    isCus = true;
                    break;
                }
                custom += lines[x++];
            }
            if (!isCus) {
                throw new IllegalArgumentException("커스텀 구분자 입력형식이 잘못되었습니다.");
            }
        }
    }

    static void divLine() { // 구분자로 나누기
        int negative = 0;
        for (int i = 0; i < ansLine1.length; i++) {
            if (isCus) {
                ansLine2 = ansLine1[i].split(custom);
                for (int j = 0; j < ansLine2.length; j++) {
                    negative = Integer.parseInt(ansLine2[j]);
                    if (negative < 0) {
                        throw new IllegalArgumentException("구분자 입력형식이 잘못되었습니다.");
                    }
                    ans += negative;
                }
            } else {
                negative = Integer.parseInt(ansLine1[i]);
                if (negative < 0) {
                    throw new IllegalArgumentException("구분자 입력형식이 잘못되었습니다.");
                }
                ans += negative;
            }
        }
    }
    public static void main(String[] args) {
        init();
        // TODO: 프로그램 구현
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            bw.write("덧셈할 문자열을 입력해 주세요.\n");
            bw.flush();
            line = Console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines = line.split("");
        chkCus();
        if (isCus) {
            for (int i = x+2; i < lines.length; i++) {
                newLine += lines[i];
            }
        } else {
            newLine = line;
        }
        ansLine1 = newLine.split("[,:]");
        divLine();
        try {
            bw.write("결과 : " + ans + "\n");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
