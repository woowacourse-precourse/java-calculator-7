package calculator;

import java.io.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = "";
        String custom = "";
        try {
            bw.write("덧셈할 문자열을 입력해 주세요.\n");
            bw.flush();
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] lines = line.split("");
        int x = 2;
        if (lines[0].equals("/") && lines[1].equals("/")) {
            while(true) {
                if (lines[x].equals("\\") && lines[x+1].equals("n")) {
                    break;
                }
                custom += lines[x++];
            }
        }
        try {
            bw.write("결과 : " + custom);
            bw.flush();
            bw.close();
        } catch (IOException e) {

        }




    }
}
