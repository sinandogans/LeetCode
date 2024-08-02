public class Main {
    //test
    public static void main(String[] args) {
        var h2o = new H2O();

        var r1 = new RunnableOne();
        var r2 = new RunnableTwo();

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    h2o.hydrogen(r1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    h2o.oxygen(r2);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
    }
}

class H2O {

    int numberOfHydrogen = 0;
    int numberOfOxygen = 0;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        synchronized (this) {
            while (numberOfHydrogen == 2) {
                if (numberOfOxygen == 1) {
                    numberOfOxygen = 0;
                    numberOfHydrogen = 0;
                    continue;
                }
                wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            numberOfHydrogen++;
            notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        synchronized (this) {
            while (numberOfOxygen == 1) {
                if (numberOfHydrogen == 2) {
                    numberOfOxygen = 0;
                    numberOfHydrogen = 0;
                    continue;
                }
                wait();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            numberOfOxygen++;
            notifyAll();
        }
    }
}

//test class
class RunnableOne implements Runnable {

    @Override
    public void run() {
        System.out.print("H");
    }
}
//test class
class RunnableTwo implements Runnable {

    @Override
    public void run() {
        System.out.print("0");
    }
}