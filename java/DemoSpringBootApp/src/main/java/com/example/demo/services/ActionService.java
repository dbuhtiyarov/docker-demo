package com.example.demo.services;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class ActionService {

    static Logger log = Logger.getLogger(ActionService.class);

    public static int createThread(int count) {
        for(int i = 0; i < count; i++) {
            (new Thread(new DemoThread())).start();
        }
        return count;
    }

    public static int gc() {
        log.info("Running GC");
        System.gc();
        return 0;
    }

    public static byte[] loadRam(int mem) {
        byte[] stab = new byte[1024 * 1024 * mem];
        log.info("Generated RAM load");
        return stab;
    }

    public static int loadCpu(int sec) {
        log.warn("Generating high CPU load for " + sec + " seconds");
        long sleepTime = sec * 1000000000L;
        long startTime = System.nanoTime();
        while ((System.nanoTime() - startTime) < sleepTime) {}
        return 0;
    }
}

class DemoThread implements Runnable {

    static Logger log = Logger.getLogger(DemoThread.class);

    public void run() {
        BasicConfigurator.configure();
        log.debug("Thread created, sleeping for 30 seconds");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            log.warn(e.getMessage());
            log.debug(e.getStackTrace());
        }
    }
}
