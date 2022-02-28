package com.cooper.effective_java.chapter04.item19;

import java.time.Instant;

// 생성자에서 호출하는 메서드를 재정의했을 때의 문제를 보여준다. (126쪽)
public final class Sub extends Super {

    private final Instant instant;

    Sub() {
        //super()가 생략되어 있다.
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println("Sub 메서드 호출 ");
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
