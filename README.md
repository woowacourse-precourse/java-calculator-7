# **🐼1주차 미션🐼 - 문자열 덧셈 계산기**

##### 오시건

### 🍪 구현할 기능 목록 🍪

1. 사용자로부터 문자열 입력받는 기능
2. 입력받은 문자열이 올바른지 검사하는 기능
3. 커스텀 구분자가 있는 문자열인지 아니면 기본 문자열인지 구분하는 기능
4. 문자열을 구분자를 기준으로 분리한 각 숫자의 합을 계산하는 기능
5. 결과값을 출력하는 기능

#### 🔵  Application Class

###### ➖ main() 함수: PlayCalculator클래스의 startConsole()함수를 실행하여 문자열 덧셈 계산 기 프로그램을 실행한다.

#### 🔴  Calculator Class

###### ➖ delimiter 변수: 커스텀 구분자를 저장하는 변수. 빈 문자열로 초기화하여 기본 생성자일때는 기본생성자만 사용

###### ➖ checkInput(String) 함수: 주어진 문자열이 기본 구분자만 사용했는지 커스텀 구분자도 사용했는지 확인

###### ➖ calculateDefaultDelimiter(String): 기본 구분자만 사용한 문자열의 합을 계산

###### ➖ calculateCustomDelimiter(String): 커스텀 구분자를 사용한 문자열의 합을 계산

#### ⚫️  InputValidator Class

###### ➖ delimiter 변수: 커스텀 구분자를 저장하는 변수. 빈 문자열로 초기화하여 기본 생성자일때는 기본생성자만 사용

###### ➖ checkDefaultDelimiter(String) 함수: 기본 구분자를 사용하여 입력된 문자열이 유효한지 확인

###### ➖ checkCustomDelimiter(String) 함수: 커스텀 구분자를 사용하여 입력된 문자열이 유효한지 확인

###### ➖ checkDelimiter(String) 함수: 입력된 문자열의 유효성 검사. 기본 구분자만 사용했으면 checkDefaultDelimiter(String)를 호출하여 결과를 return하고, 커스텀 구분자도 사용했으면 checkCustomDelimiter(String)를 호출하여 결과를 return한다.

#### 🟢  PlayCalculator Class

###### ➖ input() 함수: 사용자로부터 문자열을 입력받음

###### ➖ validateInput(String) 함수: 입력된 문자열이 유효하지 않다면 IllegalArgumentException 발생

###### ➖ startConsole() 함수: 계산기를 실행함

###### ➖ endConsole() 함수: 계산 결과를 출력함


