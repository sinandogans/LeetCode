public class Main {
    // testing purposes
    public static void main(String[] args) {

        var r1 = new RunnableFirst();
        var r2 = new RunnableSecond();
        var r3 = new RunnableThird();

        var foo = new Foo();

        Thread t1 = new Thread(() -> {
            try {
                foo.first(r1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                foo.second(r2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                foo.third(r3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }
}
// solution class
class Foo {

    volatile boolean threadAFinished = false;
    volatile boolean threadBFinished = false;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (this) {
            printFirst.run();
            threadAFinished = true;
            notify();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (!threadAFinished) {
                wait();
                notify();
            }
            threadBFinished = true;
            printSecond.run();
            notify();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
    }

    public void third(Runnable printThird) throws InterruptedException {

        synchronized (this) {
            while (!threadBFinished) {
                wait();
                notify();
            }
            printThird.run();
        }
    }
}
// testing purposes
class RunnableFirst implements Runnable {

    @Override
    public void run() {
        System.out.println("first");
    }
}

class RunnableSecond implements Runnable {

    @Override
    public void run() {
        System.out.println("second");
    }
}

class RunnableThird implements Runnable {

    @Override
    public void run() {
        System.out.println("third");
    }
}
