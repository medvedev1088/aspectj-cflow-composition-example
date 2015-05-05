package example;

public class Example {
    public void P() {
        Q();
    }

    public void Q() {
    }

    public static void main(String[] args) {
        new Example().P();
    }
}
