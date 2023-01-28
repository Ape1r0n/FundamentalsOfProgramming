interface I {
    int foo();

    static boolean batz(I x) {
        return x.foo() == 42;
    }

    default String name() {
        return batz(this) ? "abc" : null;
    }
}