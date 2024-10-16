# java-calculator-precourse

## 구현 기능 목록

### 입력
구분자와 양수로 구성된 문자열을 입력한다
>덧셈할 문자열을 입력해 주세요.  
1,2:3



#### ✔️입력 예외처리
<h5>// \n이 있을 때</h5>
- MinusSeperatorException: 구분자에 - 을 입력한 경우
- NumberSeperatorException:구분자에 숫자를 입력한 경우
- ManyGroupException: // \n이 제일 앞에 있지 않는 경우 -> 문장 제일 "앞"에 "하나"만 있어야 한다

<h5>// \n이 없을 때</h5> 
-  NoCustomSeperatorException: 쉼표와 콜론 외 문자가 있을 때



### 구분자 형성하기
- // \n 사이에 있는 문자를 구분자로 추가한다

### 문자열 더하기
구분자로 숫자를 분리한다
- 정규식을 이용하여 숫자와 문자를 분리한다
- 
#### ✔️더하기 예외처리  
- NoCustomSeperatorException: 쉼표와 콜론을 제외한 구분자가 커스텀 구분자로 설정되지 않은 경우. 

### 출력
더한 결과값을 출력한다
> 결과 : 6



