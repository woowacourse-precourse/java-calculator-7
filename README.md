# java-calculator-precourse

![image](https://github.com/user-attachments/assets/7e5f21c4-fd8f-421f-bf5a-a0e75116beb7)

> # 🧮 문자열 덧셈 계산기
입력한 문자열에서 기본 구분자 및 커스텀 구분자를 기준으로 숫자를 추출하여 더하는 계산기를 구현

<br>

> ## 📋 기능 목록
- 문자열을 입력받는 기능 ☑️
- 입력 문자열이 공백이거나 빈 문자열이면 결과값 `0`을 반환하는 기능 ☑️
- 기본 구분자(`쉼표`, `콜론`)를 기준으로 문자열을 나누는 기능 ☑️
- 커스텀 구분자(문자열 앞부분의 `"//"`, `"\n"` 사이에 위치하는 문자)를 기준으로 문자열을 나누는 기능 ☑️
- 분리한 각 숫자의 합을 구하는 기능 ☑️
- 분리한 각 숫자의 합을 출력하는 기능 ☑️

<br>

> ## 📂 클래스 분리 및 역할
프로젝트의 기능을 명확하게 분리하기 위해 각 클래스별로 역할 분담

<br>

- **`Application`**: 메인 클래스. 프로그램의 진입점으로, 입력을 받아서 각 기능을 호출하여 결과를 출력
- **`InputHandler`**: 사용자로부터 문자열을 입력받고, 커스텀 구분자를 추출 및 처리하는 클래스
- **`StringSplitter`**: 입력된 문자열을 구분자(기본 및 커스텀)로 분리하는 클래스
- **`Calculator`**: 분리된 숫자를 합산하고, 예외 처리(음수 또는 유효하지 않은 값)를 담당하는 클래스

<br>

> ## 📋 예외 처리 목록
사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 프로그램 종료

<br>

 - 커스텀 구분자를 위한 문자가 유효하지 않은 경우 (ex. "//", "\n" 중 하나만 존재) ☑️
 - 커스텀 구분자가 유효하지 않은 경우 (ex. 구분자로 문자, 특수 문자로 주어지지 않음) ☑️
 - 구분자를 기준으로 나눠진 문자열에 공백이나 빈 문자열이 포함되어 있는 경우 ☑️
 - 구분자를 기준으로 나눠진 문자열에 문자나 문자열이 포함되어 있는 경우 ☑️
 - 구분자를 기준으로 나눠진 문자열에 음수가 포함되어 있는 경우 ☑️

<br>

> ## 📺 개발 환경
- <img src="https://img.shields.io/badge/Build-%23121011?style=for-the-badge"><img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Gradle&logoColor=white"><img src="https://img.shields.io/badge/8.7-515151?style=for-the-badge">
- <img src="https://img.shields.io/badge/Language-%23121011?style=for-the-badge"><img src="https://img.shields.io/badge/java-%23ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"><img src="https://img.shields.io/badge/21-515151?style=for-the-badge">
- <img src="https://img.shields.io/badge/Project Encoding-%23121011?style=for-the-badge"><img src="https://img.shields.io/badge/UTF 8-EA2328?style=for-the-badge">
