package Week3.DynamicAnalysisUsingJavaParser;

public class Test {

    // simple file to show SimpleJPMod in action
    public static void main(String[] args) {
        System.out.println("main");
        System.out.println(f());
        System.out.println(g());
        h();
        i();
    }

    public static int f() {
        System.out.println("f");
        return 1;
    }

    public static String g() {
        System.out.println("g");
        return "a";
    }

    public static void h() {
        System.out.println("h");
        System.out.println("hello");
    }

    public static void i() {
        // I should be last... run me twice!
        System.out.println("i");
        System.out.println("Something weird will happen with the *trailing* comment in this method");
    }
    // does something weird happen here too?
}
