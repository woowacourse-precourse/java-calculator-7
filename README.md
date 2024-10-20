# java-calculator-precourse
<p align="center">
    <img src="https://i.namu.wiki/i/SkMTyiOBeQBy4NXE89AWo53cPQM1lMbEz82RGF8MTdhB9xjLY5WSV7u9NXMVbxfQ5Ie84YQd9l96-tyTbCDZFQ.webp" alt="우아한테크코스" width="250px">
</p>

# 프리코스 1주차 미션 - 문자열 덧셈 계산기

---

![Generic badge](https://img.shields.io/badge/precourse-week1-green.svg)
<!-- ![Generic badge](https://img.shields.io/badge/test-2_passed-blue.svg)
![Generic badge](https://img.shields.io/badge/version-1.0.1-brightgreen.svg) -->

> 우아한테크코스 7기 1주차 미션, 문자열 덧셈 계산기를 구현한 저장소입니다.



---
## 📝 프로젝트 개요
이 프로젝트는 문자열을 입력받아 쉼표(`,`) 또는 콜론(`:`)을 구분자로 하여 숫자들을 더하는 계산기입니다.
"\\"와 "\n"사이에 구분자를 입력하여 커스텀 구분자를 지정할 수 있습니다.


## 🔍 요구 사항 및 제약 사항
- 입력 값은 쉼표(,), 콜론(:)을 기본 구분자로 사용합니다.
- 커스텀 구분자를 사용하는 경우, "//[구분자]\n" 형식으로 입력됩니다.
- 입력 문자열이 null 또는 빈 문자열이면 0을 반환해야 합니다.
- 입력 값 중 음수가 포함되면 예외를 발생시킵니다.
- 숫자가 아닌 값이 포함된 경우에도 예외를 발생시킵니다.


## 기능 목록
1. **입력 값 검증**
   - 입력 값이 null 또는 빈 문자열일 경우 0을 반환합니다.
   - 음수를 입력할 경우 예외를 발생시킵니다.
   - 커스텀 구분자를 사용하여 숫자를 더할 수 있습니다.
  
2. **Validator 클래스 구현**
   - 입력 값에 대한 유효성 검사를 처리합니다.
   - null 또는 빈 문자열, 음수, 숫자가 아닌 값에 대한 처리를 포함합니다.

3. ** InputParser 클래스 구현**
   - 입력 문자열을 받아 기본 구분자 처리를 합니다.
   - 입력 문자열을 받아 커스텀 구분자를 처리합니다.

4. **Application 클래스 구현**
   - 입력된 문자열을 받아 파싱된 숫자들을 더하는 기능을 구현합니다.(덧셈 로직)
   - 사용자로부터 입력을 받고 결과를 출력하는 메인 실행 로직을 구현합니다.

## 📥 입출력 요구 사항

- **입력**: 구분자와 양수로 구성된 문자열
- **출력**: 덧셈 결과

### 💡 실행 결과 예시

