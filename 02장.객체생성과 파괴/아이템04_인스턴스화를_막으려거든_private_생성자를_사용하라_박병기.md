## 인스턴스화를 주의해야 하는 클래스
- 유틸 클래스 : 정적 메서드가 존재하여 주로 상속을 하지 않는 특성을 가지고 있다.
- 특정 인터페이스를 구현하는 정적 메서드로만 구성되어 있는 클래스
  - ex) java.util.Collections
- 기본 타입이나 배열을 모아둔 클래스
  - ex) java.lang.Math

<br>

## 인스턴스를 막고 싶다면?
- 인스턴스를 막고 싶다면 prvate 접근제한자를 추가해야 한다.
- private를 추가해도 Reflection API를 사용해 인스턴스화를 할 수 있다.
  - 이를 방지하기 위해서 private Constructor 내부에 에러를 발생시키도록 하자.
```java
public class UtilityClass {
    private UtilityClass() {
        throw new AssertsionError();
    }
}
```
