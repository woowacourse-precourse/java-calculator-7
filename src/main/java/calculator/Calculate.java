package calculator;

class Calculate{
    public int plusNum(Func func){
        int addNum = 0;
        for(int i=0;i<func.strToInt().size();i++){
            addNum += func.strToInt().get(i);
        }
        return addNum;
    }
}
