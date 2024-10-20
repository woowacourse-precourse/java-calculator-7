package calculator.service;

import java.util.List;

public class  CalculateService extends Service{
    NumValidService numValidService = new NumValidService();
    //커스텀 단어 추출하기
    public String extractCustoms(String str) {
        int startIndex1 = str.indexOf(CUSTOM1);
        int startIndex2 = str.indexOf(CUSTOM2);
        String c = String.valueOf(str.charAt(startIndex1+2));
        //saveSeparator(c);
        //str = str.replaceAll(CUSTOM1,"");
        //str = str.replaceAll(String.valueOf((char)13), "");
        str = str.substring(startIndex2+2);
        str = str.replaceAll(c, " ");
        return str;
    }



    public int calculate(List<String> ls, String str) {
        //ls.contains(CUSTOM1) && ls.contains(CUSTOM2)
        if(numValidService.isCustom(str)){
            str = extractCustoms(str);
        }
        for(int i=0; i<ls.size(); i++){
            String separator = ls.get(i);
            str = str.replaceAll(separator, " ");
        }

        String[] res = str.split(" ");
        int result=0;
        for(int i=0; i<res.length; i++){
            try{
                result += Integer.parseInt(res[i]);
            }catch(Exception e){

            }
        }
        return result;
    }
}
