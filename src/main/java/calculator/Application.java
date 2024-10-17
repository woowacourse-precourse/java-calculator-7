package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //setting dividers, getting inputs
        System.out.println("덧셈할 문자열을 입력해주세요.");
        StringBuilder dividers =new StringBuilder(",:");
        String input = readLine();
        if (input.startsWith("//")) {
            int newlineidx = input.indexOf("\\n");
            //proper divider not given
            if (newlineidx == -1) {
                throw new IllegalArgumentException("No Following \\n given in input");
            }
            //changing custom divider by ,
            String customdivider = input.substring(2, newlineidx);
            input=input.substring(newlineidx+2);
            dividers.append(customdivider);
        }
        // changing every divider to ,
        for (int i=0;i<dividers.length();i++) {
            input=input.replace(dividers.charAt(i),',');
        }
        int answer=0;
    //parsing numbers
    StringBuilder numbers = new StringBuilder();
    for (char c : input.toCharArray()) {
        //number given
        if (Character.isDigit(c)) {
            numbers.append(c);
        }
        //divider given
        else if  (c==','){
            answer+=numberCalc(numbers);
            numbers= new StringBuilder("");
        }
        //wrong character given
        else{
            throw new IllegalArgumentException("Not a available character given");
        }
    }
    answer += numberCalc(numbers);
    // Printing out
        System.out.println("결과 : " + answer);
}

//Function numberCalc
//Role: When Ran into divider, returns number for it.
//Parameter: StringBuilder
//Return: int
private static int numberCalc (StringBuilder numbers) {
    if (numbers.length() == 0) {
        throw new IllegalArgumentException("Null Given");
    }
    int actualnumber = Integer.parseInt(numbers.toString());
    if (actualnumber <= 0) {
        throw new IllegalArgumentException("Negative Number");
    }
    return actualnumber;
    }
}