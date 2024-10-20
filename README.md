# 문자열 덧셈 계산기

## 설계
**View : 기계 화면(개념적으로 하드웨어)** 

사용자와 상호작용(입출력)담당 - 나중에 여러가지 device를 사용한다고 가정<br>
생성자 주입으로 구체적인 device 종류를 알지 못하도록 설계

**Controller : 조립된 기계(소프트웨어) - 계산기** 

View와 Service를 연결<br>
Device interface, Calculator 구현체<br>

**Service : 기계의 기능(소프트웨어) - 계산기 기능** 

device 구현체의 동작(비즈니스 로직) 수행<br>
Calculator 기능 구현

## 구현목록
1. 구분자를 찾는 기능
2. 구분자로 숫자를 추출하는 기능
3. 추출한 숫자를 더하는 기능
4. 기능을 수행하는 Calculator 객체
5. 입출력과 calculator를 사용하는 view
6. 예외처리 (IllegalArgumentException)
   - 음수가 입력될 경우
   - 숫자가 아닌 문자가 입력될 경우 (parseInt 실패)
   - // 시작하고 \n 없는 경우
   - 커스텀 구분자를 여러개 지정한 경우
   - 커스텀 구분자가 기본 구분자일때
   - 커스텀 구분자가 숫자일때

임의로 정의한 edge case
   - 커스텀 구분자가 여러글자일때 (허용)
   - 커스텀 구분자가 띄어쓰기일때 (허용)
   - 커스텀 구분자가 여러개일때 (불허용)


## 기능목록
1. 구분자를 찾는 기능
   - //로 시작하는 경우 구분자를 찾는다
   - \n을 기준으로 구분자를 찾는다
   - //로 시작하지 않으면 , : 를 구분자로 사용한다
   - // \n 부분을 제외한 나머지를 반환
2. 구분자로 숫자를 추출하는 기능
3. 추출한 숫자를 더하는 기능

<br>
<img width="592" alt="image" src="https://github.com/user-attachments/assets/d6ff4fb1-fe9b-4ee4-9a2f-9abf65dab017">
