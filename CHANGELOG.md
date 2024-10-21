# CHANGELOG

### 2024-10-21
- **commit 08568f42414a363118d93021e481c63eb06f5538**  
  refactor(core): 주석 내용 수정

### 2024-10-20
- **commit d47191c1e3dca5f115e80e1980c52e0b7c0e8c5d**  
  refactor(Application): InputHandler 클래스 삭제  
  의존성 주입되어 있던 InputHandler 클래스를 삭제하고 run() 메서드에 직접 구현

- **commit 83e487839af6f3cfb81bda77b2841422b4fd4805**  
  refactor(Application): 객체 변수를 static으로 할당  
  클래스에서 전역적으로 사용 가능하도록 main 함수를 단순화

- **commit 3fd256548075feccd481079ca8c1069ec1ebe30b**  
  refactor(ArrayCalculator): ArrayCalculator 인터페이스 생성  
  ArraySumCalculator가 ArrayCalculator를 오버라이드하도록 변경

### 2024-10-19
- **commit e1de0c1abe65475923f641723590ae5739257485**  
  fix(StringValidatorImpl): 음수 예외 처리 오류 해결

- **commit fc21653b45f41a6600240f61011c641ee1d3f7b1**  
  feat(ArraySumCalculator): 모든 수를 더해 결과 출력  
  음수를 받았을 때 예외 처리 되지 않는 오류 발생
