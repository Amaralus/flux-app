package flux.app;

public class App {

    public String greeting() {
        return "hello mtfk";
    }

    public static void main(String[] args) {
        System.out.println(new App().greeting());
    }
}
