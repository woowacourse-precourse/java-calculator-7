package calculator;

// 이 클래스가 유저정보를 가진 클래스형태를 가짐
// 클래스가 종속되어잇지만 가변성 유지가 필요한지 여기서 더 조갤수잇는지
public class DataInfo implements UserIO{
    private String readData;

    @Override
    public String getReadline() {
        return this.readData;
    }

    @Override
    public void setReadline(String readline) {
        this.readData = readline;
    }
}
