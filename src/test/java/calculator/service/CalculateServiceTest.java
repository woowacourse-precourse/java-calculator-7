package calculator.service;

import calculator.cotroller.UserApiController;
import calculator.cotroller.UserRequestController;
import calculator.model.ExtractionData;
import calculator.model.UserInputData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {
    CalculateService calculateService = new
            CalculateService();
    NumValidService numValidService = new NumValidService();

    @Test
    void extractionTest(){
        //given
        String str = "//!\\n1!2";
        String c = "";
        //when
        if(numValidService.isCustom(str)){
            int startIndex1 = str.indexOf("//");
            int startIndex2 = str.indexOf("\\n");
            c = String.valueOf(str.charAt(startIndex1+2));
            //calculateService.saveSeparator(c);
            //str = str.replaceAll("//","");
            //str = str.replaceAll("\\n", "");
            str = str.substring(startIndex2+2);
            str = str.replaceAll(c," ");
        }
        String[] arr = str.split(" ");
        //then
        assertThat(str).isEqualTo("1 2");
    }
    @Test
    void test1(){
        String str = "//!\\n1!:1:1,1";
        int startIndex1 = str.indexOf("//");
        int startIndex2 = str.indexOf("\\n");
        String c = String.valueOf(str.charAt(startIndex1+2));
        str = str.replaceAll("//","");

        str = str.replaceAll("\\n", "");
        str = str.replaceAll(c, " ");

        assertThat(str).isEqualTo("1 :1:1,1");
    }

    @Test
    void calculateTest(){
        //given
        String str = "//!\\n1!2";
        List<String> ls = new ArrayList<>();
        ls.add(":");
        ls.add(",");
        //when
        //int res = calculateService.calculate(ls, str);
        str = calculateService.extractCustoms(str);
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
        //then
        assertThat(result).isEqualTo(3);
    }
/*    CalculateService calculateService = new
            CalculateService();
    UserApiController userApiController = new
            UserApiController();
    NumValidService numValidService = new
            NumValidService();

    @DisplayName("calculateService -exractCustoms()")
    @Test
    void exractCustomsTest(){
        //given
        String str = "//!\n12!12!12";
        //when
        calculateService.extractCustoms(str);
        List<String> res = userApiController.getCustoms();
        //then
        assertThat(res.size()).isEqualTo(1);
        assertThat(res.get(0)).isEqualTo("!");
    }
    @DisplayName("calculateService -exractCustoms()")
    @Test
    void exractCustomsTest2(){
        //given
        String str = "//!\n12!:,12!12";
        //when
        calculateService.extractCustoms(str);
        List<String> res = userApiController.getCustoms();
        //then
        assertThat(res.size()).isEqualTo(3);
    }
    @DisplayName("calculateService -exractCustoms()")
    @Test
    void exractCustomsTest3(){
        //given
        String str = "//\n12!:,12!12";
        //when
        calculateService.extractCustoms(str);
        List<String> res = userApiController.getCustoms();
        //then
        assertThat(res.size()).isEqualTo(0);
    }
    @DisplayName("calculateService -exractCustoms()")
    @Test
    void exractCustomsTest4(){
        //given
        String str = "//9\n12!:,12!12";
        //when
        calculateService.extractCustoms(str);
        List<String> res = userApiController.getCustoms();
        //then
        assertThat(res.size()).isEqualTo(0);
    }
    @DisplayName("calculateService -exractCustoms()")
    @Test
    void exractCustomsTest5(){
        //given
        String str = "//@@\n12!:,12!12";
        //when
        calculateService.extractCustoms(str);
        List<String> res = userApiController.getCustoms();
        //then
        assertThat(res.size()).isEqualTo(3);
    }


    @DisplayName("calculateSevcie -calculate()")
    @Test
    void calculateTest(){
        //given
        String str = "//!\n12!12!12,13";
        List<String> ls = new ArrayList<>();
        ls.add("//");
        ls.add("\n");
        ls.add("!");
        ls.add(",");
        //when
        for(int i=0; i<ls.size(); i++){
            if(ls.get(i).equals("//")){
                str = str.replaceAll(ls.get(i),"");
            }
            else if(ls.get(i).equals("\n")){
                str = str.replaceAll(ls.get(i),"");
            }else{
                str = str.replaceAll(ls.get(i), " ");
            }

        }
        String[] res = str.split(" ");
        int result=0;
        for(int i=1; i<res.length; i++){
            if(Integer.parseInt(res[i]) >=0 ){
                result += Integer.parseInt(res[i]);
            }
            else{

            }
        }
        //then
        assertThat(result).isEqualTo(49);
    }
*/
}