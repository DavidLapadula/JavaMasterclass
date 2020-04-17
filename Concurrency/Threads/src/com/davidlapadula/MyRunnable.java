package com.davidlapadula;

import static com.davidlapadula.ThreadColor.*;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from implemented method");
    }
}
