public class Main {

    static int MAX = 10000;
    public static void main(String[] args) {
        //part 1
        Counter counter = new Counter();
        Thread increment1 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < MAX; i++) {
                    counter.increment();
                }
            }
        };
        Thread increment2 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < MAX; i++) {
                    counter.increment();
                }
            }
        };
        Thread increment3 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < MAX; i++) {
                    counter.increment();
                }
            }
        };

        increment1.start();
        increment2.start();
        increment3.start();

        Thread decrement1 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < MAX; i++) {
                    counter.decrement();
                }
            }
        };
        Thread decrement2 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < MAX; i++) {
                    counter.decrement();
                }
            }
        };

        decrement1.start();
        decrement2.start();

        try {
            increment1.join();
            increment2.join();
            increment3.join();
            decrement1.join();
            decrement2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("1. Counter result: " + counter.getCount());

        //part 2

        Counter counter2 = new Counter();
        Thread waitAndIncrement = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < MAX; i++) {
                    counter2.waitAndIncrement();
                }
                interrupt();
            }
        };

        Thread waitAndIncrement2 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < MAX; i++) {
                    counter2.waitAndIncrement();
                }
            }
        };

        waitAndIncrement.start();

        waitAndIncrement2.start();


        try {
            waitAndIncrement.join();
            waitAndIncrement2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("2. Counter result: " + counter2.getCount());

    }
}