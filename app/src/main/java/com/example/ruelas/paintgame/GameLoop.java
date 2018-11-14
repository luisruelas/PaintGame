package com.example.ruelas.paintgame;

import android.graphics.Canvas;
import android.provider.Settings;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by Ruelas on 08/12/2016.
 */
class GameLoop extends Thread {
    SurfaceHolder sh;
    GamePanel gp;
    Boolean running=false;
    int fps = 30;
    long targettimemilis = 1000 / fps;
    long timeelapsedmilis;
    long waitime;
    int million=1000000;
    int countframe=0;
    public GameLoop(SurfaceHolder sh, GamePanel gp) {
        this.sh = sh;
        this.gp = gp;
    }

    @Override
    public void run() {
        long timeacumilis=0;
        while (running) {
            gp.update();
            long starttime = System.nanoTime();
            Canvas canvas=sh.lockCanvas();
            if (canvas!=null) {
                gp.draw(canvas);
                sh.unlockCanvasAndPost(canvas);
            }
            timeelapsedmilis= (System.nanoTime()-starttime)/million;
            waitime=targettimemilis-timeelapsedmilis;
            if (waitime>0){
                try {
                    this.sleep(waitime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            timeacumilis+=(System.nanoTime()-starttime)/million;
            countframe++;
            if (countframe==fps){
                countframe=0;
                long totalframes= (fps*1000)/timeacumilis;
                timeacumilis=0;
            }
        }

    }

    public void setRunning(Boolean running) {
        this.running = running;
    }
}