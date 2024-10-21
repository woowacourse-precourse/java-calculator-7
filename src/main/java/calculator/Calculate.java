package calculator;

public class Calculate {
    public int inputString(String str){
        CatchError catchError  = new CatchError();

        int sum = 0;
        String custom = null;

        catchError.nullCheck(str);
        CatchError.catchError(str);

        if(str.startsWith("//") && str.contains("\\n")){
            int idx = str.lastIndexOf("\\n");
            custom = str.substring(2,idx);
            str = str.substring(idx+2);
            catchError.nullCheck(custom);

            String[] input = str.split("," + custom + ":"); // 커스텀 구분자를 포함한 split
            catchError.catchError(input);
            for (String s : input) {
                sum += Integer.parseInt(s);
            }
        }
        else{
            String[] input = str.split("[,:]");

            catchError.catchError(input);
            for (String s : input) {
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }
}