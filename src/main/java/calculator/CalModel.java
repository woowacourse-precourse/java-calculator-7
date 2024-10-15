package calculator;

public class CalModel {
    public String s;
    public int sum;

    public CalModel(String s){

        this.s = s;

    }

    public String check1(String s) {

        int index1 = s.indexOf("//");
        int index2 = s.indexOf("\n");
        if (index1 != -1 && index1 < index2) {
            return check2(s, s.charAt(2));
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

        return s;
    }

}
