package calculator;

public class CalModel {
    public String s;
    public int sum;

    public CalModel(String s){

        this.s = s;

    }

    public String check1(String s) {


        int index1 = s.indexOf("//");
        int index2 = s.indexOf("\\n");
        s = s.replace("//", ",");
        s = s.replace("\\n", ",");
        if (index1 != -1 && index1 < index2) {
            return check2(s, s.charAt(1));
        }
        else {
            return check2(s, ',');
        }
    }

    public String check2(String s, char c) {
        s = s.replace(',', ':');
        s = s.replace(c, ':');

        for(int i = 0;i < s.length();i++) {

            if((s.charAt(i)-'0' > 10 || s.charAt(i)-'0' < 1) && (s.charAt(i) != ':')) {
                throw new IllegalArgumentException();
            }
        }

        return s.replace(':', ' ').strip().replaceAll(" +"," ");
    }

    public int intSum(String s) {

        int result = 0;

        String[] temp = s.split(" ");

        for(String var : temp) {
            result += Integer.parseInt(var);
        }

        return result;
    }

}
