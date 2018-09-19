package com.example.ANR;

import android.os.Looper;

public class ANRException extends RuntimeException {
    public ANRException() {
        super("ANR happened");
        Thread mainThread = Looper.getMainLooper().getThread();
        setStackTrace(mainThread.getStackTrace());
    }

}
