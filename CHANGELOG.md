#### 2024-10-18

##### Documentation Changes

* **README.MD:**
  *  현재까지 구현한 기능 목록 체크 (88412747)
  * 현재까지 구현한 기능 목록 체크 (5226e4bb)
* **README.md:**  구현할 기능 목록 작성 (15e6e70a)

##### New Features

* **application:**  CalculatorController를 통한 계산 시작 (2cfa8eb2)
* **controller:**  model과 view를 연결해주는 컨트롤러 추가 (290502d7)
* **model:**
  *  숫자를 더하는 클래스 추가 - 숫자를 더하여 결과를 반환한다. (f0f1744b)
  *  입력된 문자열을 관리하는 클래스 추가 - `Delimiters`에 있는 구분자들을 문자열에서 제거한다. - 문자를 숫자로 변환하여 리스트로 반환할 수 있다. (2294ac76)
  *  구분자를 관리하는 일급 컬렉션 추가 - `DefaultDelimiterType`으로부터 값을 가져와 기본 구분자를 등록한다. - `CustomDelimiter`로부터 커스텀 구분자를 등록할 수 있다. (60f7d72f)
  *  기본 구문자 타입을 정의하는 enum 클래스 추가 ,와;를 필드로 가진다. (1a1ca67a)
  *  구분자 인터페이스 및 기본/커스텀 구분자 구현 클래스 추가 구분자를 처리하는 인터페이스인 Delimiter 추가 및 기본 구분자와 커스텀 구분자 클래스를 통해 구체화. (2c9e3740)
* **view:**  입력 및 출력 뷰 클래스 추가 사용자 입력을 받고 결과를 출력하는 기능을 제공하는 InputView와 OutputView 클래스를 추가. (5333dbe2)
*  setup project (d0a82b7d)

#### 2024-10-18

##### Documentation Changes

* **README.MD:**
  *  현재까지 구현한 기능 목록 체크 (88412747)
  * 현재까지 구현한 기능 목록 체크 (5226e4bb)
* **README.md:**  구현할 기능 목록 작성 (15e6e70a)

##### New Features

* **application:**  CalculatorController를 통한 계산 시작 (2cfa8eb2)
* **controller:**  model과 view를 연결해주는 컨트롤러 추가 (290502d7)
* **model:**
  *  숫자를 더하는 클래스 추가 - 숫자를 더하여 결과를 반환한다. (f0f1744b)
  *  입력된 문자열을 관리하는 클래스 추가 - `Delimiters`에 있는 구분자들을 문자열에서 제거한다. - 문자를 숫자로 변환하여 리스트로 반환할 수 있다. (2294ac76)
  *  구분자를 관리하는 일급 컬렉션 추가 - `DefaultDelimiterType`으로부터 값을 가져와 기본 구분자를 등록한다. - `CustomDelimiter`로부터 커스텀 구분자를 등록할 수 있다. (60f7d72f)
  *  기본 구문자 타입을 정의하는 enum 클래스 추가 ,와;를 필드로 가진다. (1a1ca67a)
  *  구분자 인터페이스 및 기본/커스텀 구분자 구현 클래스 추가 구분자를 처리하는 인터페이스인 Delimiter 추가 및 기본 구분자와 커스텀 구분자 클래스를 통해 구체화. (2c9e3740)
* **view:**  입력 및 출력 뷰 클래스 추가 사용자 입력을 받고 결과를 출력하는 기능을 제공하는 InputView와 OutputView 클래스를 추가. (5333dbe2)
*  setup project (d0a82b7d)

#### 2024-10-17

##### New Features

*  setup project (d0a82b7d)

