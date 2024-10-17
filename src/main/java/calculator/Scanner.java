package calculator;
import java.util.ArrayList;
public class Scanner {

    private ArrayList<Integer> output;
    private char customDelimiter=',';

    enum State {
        START,
        NUMBER,
        DELIMITER,
        END
    }
    ArrayList<Integer> getOutput() {
        return output;
    }
    public Scanner(String input)  {
        State state= State.START;
        output=new ArrayList<>();
        StringBuilder cur_num=new StringBuilder();

        //커스텀 구분자 처리
        if(input.startsWith("//")) {
            int delimiterEndIndex=input.indexOf("\\n");
            if(delimiterEndIndex !=-1) {
                customDelimiter=input.substring(2,delimiterEndIndex).charAt(0);
                input=input.substring(delimiterEndIndex+2);
            }
        }
        System.out.println("customDeliiter: " + customDelimiter);
        System.out.println("input:" + input);


        for(char ch: input.toCharArray()) {
            switch(state) {
                case START:
                    if (Character.isDigit(ch)) {
                        state=State.NUMBER;
                        cur_num.append(ch);
                    } else if(!isDelimiter(ch,customDelimiter)) {
                        throw new IllegalArgumentException("Invaild input: " + ch);
                    }
                    break;
                case NUMBER:
                    if(Character.isDigit(ch)) {
                        cur_num.append(ch);
                    } else if(isDelimiter(ch,customDelimiter)) {
                        state=State.DELIMITER;
                        output.add(Integer.parseInt(cur_num.toString()));
                        cur_num.setLength(0);
                    } else {
                        throw new IllegalArgumentException("Invaild input: " + ch);
                    }
                    break;
                case DELIMITER:
                    if(Character.isDigit(ch)) {
                        state=State.NUMBER;
                        cur_num.append(ch);
                    } else if(!isDelimiter(ch,customDelimiter)) {
                        throw new IllegalArgumentException("Invaild input: " + ch);
                    }
                    break;
            }

        }

        if(cur_num.length()>0) {
            output.add(Integer.parseInt(cur_num.toString()));
        } else if(output.isEmpty()) {
            output.add(0);
        }
    }

    private static boolean isDelimiter(char ch,char custom_char) {

        return ch == ';' || ch == ',' || ch==custom_char;
    }



}
