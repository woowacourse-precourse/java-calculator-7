package calculator;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {


        try {
            String input_sen = Console.readLine();
            int sum = 0;
            StringBuilder target_op = new StringBuilder(",:");
            StringBuilder temp_buf = new StringBuilder();

            for (int i = 0; i < input_sen.length(); i++) {
                String c = String.valueOf(input_sen.charAt(i));

                if (target_op.toString().contains(c)) {
                    // temp_buf 를 숫자로 바꿔서 더하기
                    sum += Integer.parseInt(temp_buf.toString());

                    temp_buf = new StringBuilder();
                } else if (c.equals("/")) {
                    // add char
                    if (input_sen.length() >= i + 1) {
                        if (input_sen.charAt(i + 1) == '/'
                                && input_sen.charAt(i + 3) == '\\'
                                && input_sen.charAt(i + 4) == 'n') {
                            target_op.append(input_sen.charAt(i + 2));
                            i = i + 4;
                        } else {
                            throw new IllegalArgumentException("String cannot be converted to Integer"); // 특정 예외를 던짐
                        }

                    }
                } else {// 포함되어있는 기호가 아닐때
                    // - 기호는 예외처리
                    try {
                        Integer.parseInt(c);
                    }
                    catch(Exception e) {
                        throw new IllegalArgumentException("String cannot be converted to Integer"); // 특정 예외를 던짐
                    }
                    // 숫자일 때
                    temp_buf.append(c);

                }
            }
            sum += Integer.parseInt(temp_buf.toString());
            System.out.println("결과 : " + sum);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("String cannot be converted to Integer"); // 특정 예외를 던짐
        }
        catch (Exception e){
            throw new IllegalArgumentException("String cannot be converted to Integer... maybe"); // 특정 예외를 던짐
        }

        //end
        Console.close();
    }
}
