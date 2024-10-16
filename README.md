# 문자열 덧셈 계산기

## 기능 요구 사항
___
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 요구 기능 사항 목록
___
- [ ] 엔티티 작성하기
  - [ ] Calculator (계산기 역할을 해줄 클래스, 여러개의 Number 클래스를 가진다.)
  - [ ] Number (숫자를 저장할 클래스)
- [ ] 문자열을 입력받을 수 있다.
  - [ ] Input/Output 만들기
  - [ ] 문자열 입력받기
- [ ] 구분자를 통해 문자열을 분리할 수 있다.
  - [ ] 구분자를 통해 문자열 분리하기
  - [ ] 숫자별 Number 엔티티 만들기
  - [ ] Calculator 엔티티 만들기
- [ ] 각 숫자의 합을 구할 수 있다.
  - [ ] Calculator 클래스를 통해 합 구하기
- [ ] 커스텀 구분자를 사용할 수 있다.
  - [ ] 커스텀 구분자 생성하기
  - [ ] 커스텀 구분자 기능을 추가하여 합 구하기