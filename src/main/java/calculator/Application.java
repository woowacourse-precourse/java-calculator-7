package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();

        String input = app.getInputString();

        String[] slice;
        if(input.startsWith("/")){
            slice = app.customSliceString(input);
        }else {
            slice = app.sliceString(input);
        }

        int[] numList = app.stringArrayToIntArray(slice);
        int sum = app.sumList(numList);
        System.out.println(sum);
    }

    public String getInputString(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public String[] sliceString(String input){
        String[] slice = input.split("[,;]");
        return slice;
    }

    public int[] stringArrayToIntArray(String[] slice){
        int[] numList = new int[slice.length];

        for (int i = 0; i < slice.length; i++) {
            numList[i] = Integer.parseInt(slice[i]);
        }
        return numList;
    }

    public int sumList(int[] numList){
        int sum = 0;
        for (int j : numList) {
            sum += j;
        }
        return sum;
    }

    public String[] customSliceString(String input){
        input = input.replace("\\n","\n");
        String[] s = input.split("\n");
        String custom = s[0].substring(2);
        String[] slice = s[1].split(Pattern.quote(custom));
        return slice;
    }
}
