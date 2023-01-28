public class DercrementUsingTwoThreads {
    static Integer counter;

    public static synchronized void reducer(){
        if(counter > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + counter);
            counter--;
        }
    }
    static class testThread extends Thread{
        testThread(Integer x){
            counter = x;
        }

        @Override
        public void run() {
            while(counter > 0) reducer();
        }
    }

    public static void main(String[] args) {
        int x = 10000;
        new testThread(x).start();
        new testThread(x).start();
    }
}