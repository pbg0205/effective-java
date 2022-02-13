## 1. close() 함수의 불편함
- 자바 라이브러리에는 close 메서드를 호출해 직접 닫아줘야 하는 자원이 많다.
- 자원 닫기는 클라이언트가 놓치기 쉬워서 예측할 수 없는 성능 문제로 이어지기도 한다.
- 이런 자원 중 상당수가 안전망으로 finalizer를 활용하고는 있지만 finalizer 는 그리 믿을만하지 못하다.

<br>

## 2. try-finally 구문의 결함

```java
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
```

- 위와 같은 코드에서 내부 try-finally 구문에서 에러가 발생할 경우, 내부 예외가 외부 예외로 잡아 삼켜져 원인 파악이 어려울 수 있다.
    - 이 때, 스택 추정 내용에 첫 번째 예외에 관한 정보가 입력되지 않아 디버깅 하는데 어려움이 생긴다.

## 3. try-with-resources 로 해결 되었음.
- 자바7 부터 Autoclosable 인터페이스를 구현한 클래스는 try-with-resources를 사용할 수 있다.
- try-with-resources를 사용하면 읽기 수월하고 문제를 진단하기 훨씬 수월하다.

```java
    static void copy(String src, String dst) throws IOException {
        try (InputStream   in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }
```
- 위 코드와 같이 close 호출 양쪽 모두 예외가 발생할 경우, close에서 발생한 예외는 숨겨지고 readLine 에서 발생한 예외가 기록된다.
- try-with-resources 는 try-finally 와 같이 catch 절을 사용할 수 있다.