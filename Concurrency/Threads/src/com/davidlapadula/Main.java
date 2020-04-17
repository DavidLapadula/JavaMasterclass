package com.davidlapadula;

import static com.davidlapadula.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Main thread running");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another thread");
        anotherThread.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from anonymous MyRunnable");

                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "Another thread terminated or timed out, so running again");
                } catch(InterruptedException e) {
                    System.out.println(ANSI_RED + "Was interrupted");
                }
            }
        });

        myRunnableThread.start();

        System.out.println(ANSI_PURPLE + "Main thread running two");
    }
}
