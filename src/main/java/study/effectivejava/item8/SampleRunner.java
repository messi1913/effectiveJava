package study.effectivejava.item8;

public class SampleRunner {

    public static void main(String[] args) {
        try(var sampleResource = new SampleResource()) {
            sampleResource.hello();
        }
    }
}
