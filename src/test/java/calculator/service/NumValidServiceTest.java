package calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumValidServiceTest {
    NumValidService numValidService = new NumValidService();
/*
    @DisplayName("NumValidService - isCustom():true")
    @Test
    void isCustomTest(){
        //given
        String str = "//%\n12%213";
        //when
        boolean res = numValidService.isCustom(str);
        //then
        assertThat(res).isTrue();
    }
    @DisplayName("NumValidService - isCustom():false")
    @Test
    void isCustomTest2(){
        //given
        String str = "12%213";
        //when
        boolean res = numValidService.isCustom(str);
        //then
        assertThat(res).isFalse();
    }
    @DisplayName("NumValidService - isCustom():false")
    @Test
    void isCustomTest3(){
        //given
        String str = "\n1//12%213";
        //when
        boolean res = numValidService.isCustom(str);
        //then
        assertThat(res).isFalse();
    }


    @DisplayName("NumValidService - isDefault(): true")
    @Test
    void isDefaultTest(){
        //given
        String str = "//\n1:2:3";
        //when
        boolean res = numValidService.isDefault(str);
        //then
        assertThat(res).isTrue();
    }
    @DisplayName("NumValidService - isDefault(): false")
    @Test
    void isDefaultTest2(){
        //given
        String str = "//!\n1!3!";
        //when
        boolean res = numValidService.isDefault(str);
        //then
        assertThat(res).isFalse();
    }


    @DisplayName("NumValidService - removeCustomStr(): true")
    @Test
    void removeCustomStrTest(){
        //given
        String str = "//!\n12!23!:";
        //when
        String res = numValidService.removeCustomString(str);
        //then
        assertThat(res).isEqualTo("1223:");
    }
    @DisplayName("NumValidService - removeDefaultStr()")
    @Test
    void removeDefaultStrTest(){
        //given
        String str = "//@\n1:2:,4";
        //when
        String res = numValidService.removeDefaultString(str);
        //then
        assertThat(res).isEqualTo("//@\n124");
    }


    @DisplayName("NumValidService - customValid(): true")
    @Test
    void customValidTest(){
        //given
        String str = "//!\n12!23!";
        //when
        boolean res = numValidService.customValid(str);
        //then
        assertThat(res).isTrue();
    }
    @DisplayName("NumValidService - customValid(): false(null)")
    @Test
    void customValidTest2(){
        //given
        String str = "//\n12!23!";
        //when
        boolean res = numValidService.customValid(str);
        //then
        assertThat(res).isFalse();
    }
    @DisplayName("NumValidService - customValid(): false(num)")
    @Test
    void customValidTest3(){
        //given
        String str = "//9\n12!23!";
        //when
        boolean res = numValidService.customValid(str);
        //then
        assertThat(res).isFalse();
    }


    @DisplayName("NumValidService -defaultValid(): true")
    @Test
    void defaultValidTest(){
        //given
        String str = "1:2,:3,4";
        //when
        boolean res = numValidService.defaultValid(str);
        //then
        assertThat(res).isTrue();
    }
    @DisplayName("NumValidService -defaultValid():false")
    @Test
    void defaultValidTest2(){
        //given
        String str = ")1:2,:3,4";
        //when
        boolean res = numValidService.defaultValid(str);
        //then
        assertThat(res).isFalse();
    }

    @DisplayName("NumValidService -inputValid():true(custom)")
    @Test
    void inputValidTest(){
        //given
        String str = "//n\n12n13n";
        //when
        boolean res = numValidService.inputValid(str);
        //then
        assertThat(res).isTrue();
    }
    @DisplayName("NumValidService -inputValid():false(custom:null)")
    @Test
    void inputValidTest2(){
        //given
        String str = "//\n12n13n";
        //when
        boolean res = numValidService.inputValid(str);
        //then
        assertThat(res).isFalse();
    }
    @DisplayName("NumValidService -inputValid():false(custom:num)")
    @Test
    void inputValidTest3(){
        //given
        String str = "//1\n12n13n";
        //when
        boolean res = numValidService.inputValid(str);
        //then
        assertThat(res).isFalse();
    }
    @DisplayName("NumValidService -inputValid():true(default)")
    @Test
    void inputValidTest4(){
        //given
        String str = "12:13,";
        //when
        boolean res = numValidService.inputValid(str);
        //then
        assertThat(res).isTrue();
    }
    @DisplayName("NumValidService -inputValid():false(default: exception)")
    @Test
    void inputValidTest5(){
        //given
        String str = "12:13,?";
        //when
        boolean res = numValidService.inputValid(str);
        //then
        assertThat(res).isFalse();
    }
    @DisplayName("NumValidService -inputValid():true(default&custom)")
    @Test
    void inputValidTest6(){
        //given
        String str = "//!\n1!2:13,";
        //when
        boolean res = numValidService.inputValid(str);
        //then
        assertThat(res).isTrue();
    }
    @DisplayName("NumValidService -inputValid():false(default&custom: num)")
    @Test
    void inputValidTest7(){
        //given
        String str = "//1\n112:13,";
        //when
        boolean res = numValidService.inputValid(str);
        //then
        assertThat(res).isFalse();
    }
    @DisplayName("NumValidService -inputValid():false(default&custom: null)")
    @Test
    void inputValidTest8(){
        //given
        String str = "//\n1!2:13,";
        //when
        boolean res = numValidService.inputValid(str);
        //then
        assertThat(res).isFalse();
    }
    @DisplayName("NumValidService -inputValid():false(default&custom: exception)")
    @Test
    void inputValidTest9(){
        //given
        String str = "\n//1!2:13,";
        //when
        boolean res = numValidService.inputValid(str);
        //then
        assertThat(res).isFalse();
    }
    @DisplayName("NumValidService -inputValid():false(default&custom: exception)")
    @Test
    void inputValidTest10(){
        //given
        String str = "\n!//jsdjjlk";
        //when
        boolean res = numValidService.inputValid(str);
        //then
        assertThat(res).isFalse();
        /

    }*/
}