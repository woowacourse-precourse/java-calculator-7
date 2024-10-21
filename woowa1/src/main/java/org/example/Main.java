package org.example;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Character> target_op = new ArrayList<>();
        target_op.add(',');
        target_op.add(':');

        // input
        System.out.println("입력해주세요");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // action
        String input_sen = br.readLine();
        String temp_buf = "";
        int sum = 0;
        try {

            // ++
            for (int i = 0; i < input_sen.length(); i++) {
                char c = input_sen.charAt(i);
                //System.out.println(i + " " + c);
                if (target_op.contains(c)) {
                    // temp_buf 를 숫자로 바꿔서 더하기

                    sum += Integer.parseInt(temp_buf);
                    //System.out.println(sum);
                    temp_buf = "";
                } else if (c == '/') {
                    // add char
                    if (input_sen.length() >= i + 4) {
                        if (input_sen.charAt(i + 1) == '/'
                                && input_sen.charAt(i + 3) == '\\'
                                && input_sen.charAt(i + 4) == 'n') {
                            target_op.add(input_sen.charAt(i + 2));
                            i = i + 4;
                        } else {
                            // error
                            throw new IllegalArgumentException("String cannot be converted to Integer: " + c); // 특정 예외를 던짐

                        }

                    }
                } else {// 포함되어있는 기호가 아닐때
                    //todo 숫자가 아닐때 error
                    // 숫자일 때
                    Integer.parseInt(String.valueOf(c));


                    temp_buf = temp_buf + c;

                }
            }
            sum += Integer.parseInt(temp_buf);
        }
        catch(Exception e){
            throw new IllegalArgumentException("String cannot be converted to Integer"); // 특정 예외를 던짐
   }

        // output
        System.out.println(sum);

    }
}