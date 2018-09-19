package com.example.ANR;

import android.os.Handler;
import android.os.Message;

public class ANRWatchDog implements Runnable {

    public static final int MESSAGE_WATCHDOG_TIME_TICK = 0;
    /**
     * ANR time Threshhold
     */
    public static final int ACTIVITY_ANR_TIMEOUT = 2000;


    private static int lastTimeTick = -1;

    private static int timeTick = 0;
    private Handler watchDogHandler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            timeTick++;
            timeTick = timeTick % Integer.MAX_VALUE;
        }
    };


    @Override
    public void run() {
        while (true) {
            watchDogHandler.sendEmptyMessage(MESSAGE_WATCHDOG_TIME_TICK);
            try {
                Thread.sleep(ACTIVITY_ANR_TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // ANR happens
            if (timeTick == lastTimeTick) {
                throw new ANRException();
            } else {
                lastTimeTick = timeTick;
            }
        }

    }
}

