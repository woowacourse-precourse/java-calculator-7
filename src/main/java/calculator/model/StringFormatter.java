package calculator.model;

public class StringFormatter {

    public static int[] toIntArr(String[] strInput) {
        int[] intArr = new int[strInput.length];

        for (int i = 0; i < strInput.length; i++) {
            if(strInput[i].isEmpty()){
                intArr[i] = 0;
            }else{
                try{
                    intArr[i] = Integer.parseInt(strInput[i]);
                }catch (Exception e){
                    //예외 처리 구현에서 추가
                }
            }
        }
        return intArr;
    }
}
