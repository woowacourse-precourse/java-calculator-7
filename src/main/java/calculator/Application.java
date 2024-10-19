package calculator;

import java.io.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = "";
        String newLine = "";
        String custom = "";
        String[] ansLine1 = {};
        String[] ansLine2 = {};
        boolean isCus = false;
        int ans = 0;
        try {
            bw.write("덧셈할 문자열을 입력해 주세요.\n");
            bw.flush();
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] lines = line.split("");
        int x = 2;
        if (lines[0].equals("/") && lines[1].equals("/")) { // 커스텀 구분자 추가
            while (x < lines.length) {
                if (lines[x].equals("\\") && lines[x+1].equals("n")) {
                    isCus = true;
                    break;
                }
                custom += lines[x++];
            }

        }
        if (isCus) {
            for (int i = x+2; i < lines.length; i++) {
                newLine += lines[i];
            }
        } else {
            newLine = line;
        }
        ansLine1 = newLine.split("[,:]");
        for (int i = 0; i < ansLine1.length; i++) {
            if (isCus) {
                ansLine2 = ansLine1[i].split(custom);
                for (int j = 0; j < ansLine2.length; j++) {
                    ans += Integer.parseInt(ansLine2[j]);
                }
            } else {
                ans += Integer.parseInt(ansLine1[i]);
            }
        }

        try {
            bw.write("결과 : " + ans + "\n");
            for (int i = 0; i < ansLine1.length; i++) {
                bw.write(ansLine1[i] + "\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
