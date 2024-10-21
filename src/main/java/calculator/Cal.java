package calculator;

import static java.lang.Character.isDigit;

public class Cal {
    int k; char c1=',',c2=':',c3;
    String word=new String();
    int size=0;
    int sum=0;
    String a="0";
    public Cal(int k, char c3,String word,int size){
        this.k = k;
        this.c3=c3;
        this.word=word;
        this.size=size;
    }


    public int getSum(){
        while(k<size){
            if(word.charAt(k)!=c1&& word.charAt(k)!=c2 && word.charAt(k)!=c3){
                if(isDigit(word.charAt(k))){
                    a+=word.charAt(k);
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                sum+=Integer.parseInt(a);
                a="0";
            }
            k++;
        }
        sum+=Integer.parseInt(a);
        return sum;
    }




}
