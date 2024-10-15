package calculator;

public class SplitMethod {
    public int split(String input) {

        int sum = 0;

        if(input.contains(",") || input.contains(":")) {
            String newStr = input.replaceAll(",", "").replaceAll(":", "");
            String[] seperated = newStr.split("");

            for (int i = 0; i < seperated.length; i++) {
                sum += Integer.parseInt(seperated[i]);
            }
        }
        else if (input.startsWith("//")) {
            int find = input.indexOf("\\");
            String id = input.substring(2, find);
//            System.out.println(id);
            String s = input.replaceAll("/", "").replace("\\n", "").replaceAll(";","");
//            System.out.println(s);
            String[] tokens = s.split("");

            for (int i = 0; i < tokens.length; i++) {
                sum += Integer.parseInt(tokens[i]);
            }

            System.out.println("결과 : " + sum);
        }

        return sum;
    }
}
