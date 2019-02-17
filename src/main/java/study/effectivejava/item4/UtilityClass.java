package study.effectivejava.item4;

public class UtilityClass {

    private UtilityClass() {
        // 생성자 호출 시 에 에러를 발생합니다.
        throw new AssertionError();
    }

    public static void main(String[] args) {
        UtilityClass utilityClass = new UtilityClass();
    }
}
