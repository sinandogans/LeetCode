public class Main {
    public static void main(String[] args) {
        var fooBar = new FooBar(10);

        var r1 = new RunnableOne();
        var r2 = new RunnableTwo();

        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(r1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(r2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
    }
}

class FooBar {
    private int n;
    boolean isFooTurn = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (!isFooTurn) {
                    wait();
                    i--;
                    continue;
                }
                printFoo.run();
                isFooTurn = false;
                notifyAll();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (isFooTurn) {
                    wait();
                    i--;
                    continue;
                }
                printBar.run();
                isFooTurn = true;
                notifyAll();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        }
    }
}

//test class
class RunnableOne implements Runnable {

    @Override
    public void run() {
        System.out.print("foo");
    }
}

//test class
class RunnableTwo implements Runnable {

    @Override
    public void run() {
        System.out.print("bar");
    }
}