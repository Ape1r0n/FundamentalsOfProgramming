public class A implements I{
    private int secret;

    public A(int secret) {
        this.secret = secret;
    }

    @Override
    public int foo() {
        return secret;
    }

    static int f(){
        return 42;
    }


    public static void main(String[] args) {
        double x = Float.MAX_VALUE;
        x++;
        // System.out.println(x);
        String str = "Penguin";
        System.out.println(str);
    }
}