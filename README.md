# java-calculator-precourse


# 🧮 문자열 계산기 기능 요구사항

## 🖥️ 입출력 
- [x] 입력
	- [x] 사용자로부터 입력 받기
- [x] 출력
	- [x] 사용자로부터 입력 받기 전 입력 문구 출력
	- [x] 계산 결과 출력

## 🔤 문자열 처리 
- [ ] 입력 문자열 검증
  - [ ] 빈 문자열 확인
  - [ ] 문자열 형식 검증
- [ ] 구분자 처리
  - [ ] 기본 구분자(쉼표, 콜론) 식별
  - [ ] 커스텀 구분자 식별 및 추출
    - [ ] "//"와 "\\n" 사이에 정의된 커스텀 구분자 처리
- [ ] 문자열 파싱
  - [ ] 구분자를 기준으로 문자열 분리
  - [ ] 개별 문자열 추출

## 🔢 숫자 변환 
- [ ] 추출된 문자열을 숫자로 변환
  - [ ] 정수 변환
  - [ ] 음수 처리
- [ ] 변환된 숫자의 유효성 검사

## 🧮 계산 
- [ ] 변환된 숫자들의 합계 계산

## ⚠️ 예외 처리 
- [ ] `IllegalArgumentException` 발생 및 처리
  - [ ] 문자열이 아닌 입력 처리
  - [ ] 정의되지 않은 구분자 처리
  - [ ] 잘못된 커스텀 구분자 형식 처리
  - [ ] 구분자 사이에 숫자가 아닌 값 처리
  - [ ] 숫자 변환 시 발생하는 예외 처리

## 🚀 확장성
- [ ] 연산 확장
  - [ ] 덧셈 외에 다른 계산 기능 추가 시 구조 설계
- [ ] 다중 구분자
  - [ ] 여러 개의 커스텀 구분자를 입력 받을 경우의 처리 방법
- [ ] 입력값 변환
  - [ ] 문자열이 아닌 숫자 리스트를 입력으로 받을 경우 처리 방법
