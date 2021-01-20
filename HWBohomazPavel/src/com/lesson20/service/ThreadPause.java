package com.lesson20.service;

import com.lesson20.Main;

public class ThreadPause {

    private Thread initThread;

    public ThreadPause(Thread initThread) {
        this.initThread = initThread;
        threadIterator();
    }

    private void threadIterator() {
        Main.atmArrayList.stream().peek(e ->{
            if (e != initThread) pause(initThread);
        });
    }

    private void pause(Thread o) {
        try {
            o.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
