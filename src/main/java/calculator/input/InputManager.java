package calculator.input;

public interface InputManager {
    /**
     * “//{커스텀 구분자}\n” 입력에는 두번째 라인을 빈문자열 취급하고
     * “//{커스텀 구분자}”은 분명히 잘못된 형식의 요청이기 때문에 IllegalArgmentExeception을 발생시키고 싶었지만
     *
     * Console API 에서 호출이 가능한 메서드가 readLine()과 close()밖에 존재하지 않기 때문에 “//{커스텀 구분자}”와
     * 구별할 수 있는  방법을 찾을 수 없었다.
     *
     * 사용자 이용을 고려하면 커스텀 구분자를 입력한다는거 자체가 그 커스텀 구분자를 사용하기 위한 것이기 때문에
     * “//{커스텀 구분자}\n” 입력을 해도 뒤에 아예 빈문자열이 오는 것은 잘못된 입력이라고 판단하고
     * IllegalArgmentExeception를 던지도록 만들었다.
     */
    void saveSeparatorAndNumbers();
}
