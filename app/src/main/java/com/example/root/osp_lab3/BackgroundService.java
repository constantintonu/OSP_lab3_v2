package com.example.root.osp_lab3;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by root on 26.10.2016.
 */

public class BackgroundService extends Service {
    PiComputer picomp;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String precision = null;

        Bundle extras = intent.getExtras();
        if(extras != null) {
            if(extras.containsKey("precision")) {
                precision = extras.get("precision").toString();
            }
        }

        if(precision != null) {
            compute(Integer.parseInt(precision));
        }

        return Service.START_NOT_STICKY;
    }

    private void compute(int prec) {
        picomp = new PiComputer(prec);

        picomp.compute();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
