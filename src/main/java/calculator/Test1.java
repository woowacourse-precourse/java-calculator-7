package calculator;



public class Test1 {

    public static void add(String str) {
        String[] list = str.split("[/,:]");

        int sum = 0;
        for (String s : list) {
            sum += Integer.parseInt(s);
        }

        System.out.println(sum);
    }
}
