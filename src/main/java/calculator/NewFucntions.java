package calculator;


import static camp.nextstep.edu.missionutils.Console.*;

class NewFucntions {
    String[] str;

    public NewFucntions() {}

    public void init(){
        DataInfo dataInfo = new DataInfo();
        Parsing parsing = new Parsing();

        //input msg print
        System.out.println(Constants.PRINT_IN_MSG);
        //read User input
        dataInfo.setReadline(readLine());
        //
        str = parsing.CustomDelimiterCheck(dataInfo.getReadline());

        System.out.println(Constants.PRINT_OUT_MSG + parsing.ExceptionCheck(str) );

    }


}
