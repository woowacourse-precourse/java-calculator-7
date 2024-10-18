package calculator;

public class Test2 {
    public static void custom (String input){
        int start = input.indexOf("//");
        int last = input.indexOf("\\n");

        String customString = input.substring(start+2, last);
        String str = input.substring(last+2);
        System.out.println(str);
        String[] list = str.split(customString);

        int sum = 0;
        for (String s : list) {
            sum += Integer.parseInt(s);
        }

        System.out.println(sum);
    }
}
