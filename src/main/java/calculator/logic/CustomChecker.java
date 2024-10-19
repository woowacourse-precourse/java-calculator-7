package calculator.logic;


public class CustomChecker {

    public static char[] customArray  = new char[10];


    public static String getCustom(String str) {
        StringBuilder sb = new StringBuilder();

        if(str.charAt(0) == '/' && str.charAt(1)=='/'){
            for(int i=2; i<str.length(); i++) {
                if(str.charAt(i-1) == '\\' && str.charAt(i)=='n') {
                    for(int j=0; j<i-3; j++) {
                        //  System.out.println("j:"+j+" i:"+(i-2)+" "+str.charAt(j));
                        sb.append(str.charAt(j + 2));
                    }
                }
            }
        }
        return sb.toString();
    }



    public static boolean isCustom(String str) {
        return str.startsWith("//");
    }
}
