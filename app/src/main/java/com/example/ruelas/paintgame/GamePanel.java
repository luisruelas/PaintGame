package com.example.ruelas.paintgame;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ruelas on 08/12/2016.
 */
public class GamePanel extends SurfaceView {
    public static int WIDTHBGTOP =259;
    public static int HEIGHTBGTOP =194;
    public static float scalefactorx=0;
    public static float scalefactory=0;
    public long dropstarttime;
    public float topfraction=0.75f;
    Random rand;
    Context context;
    BackgroundTop bg;
    ArrayList<Bucket>buckets;
    ArrayList<Drop> drops;
    int maxbuckets=2;
    int currentbuckets=0;
    public GamePanel(Context context) {
        super(context);
        this.context=context;
        rand=new Random();
        GameLoop gl= new GameLoop(getHolder(),this);
        bg= new BackgroundTop(context);
        drops =new ArrayList<>();
        //buckets
        buckets=new ArrayList<>();
        //time de drop
        dropstarttime=System.nanoTime();

        gl.setRunning(true);
        gl.start();
    }
    public void update(){
    bg.update();
        //añadirgotascontime
        long dropelapsedmilis=(System.nanoTime()-dropstarttime)/1000000;
        //tiempo entre x y y
        int randomizer=rand.nextInt(300);
        if(dropelapsedmilis>800+randomizer){
            drops.add(new Drop((int) ((HEIGHTBGTOP -5)*rand.nextDouble()), rand.nextInt(Drop.maxcolor)));
            dropstarttime=System.nanoTime();
        }
        //update drops
        for(int i = 0; i< drops.size(); i++){
            drops.get(i).update();
            if(drops.get(i).gety()> scalefactory*HEIGHTBGTOP*2/4){
                drops.remove(i);
            }
        }
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        scalefactorx=getWidth()/ (WIDTHBGTOP*1f);
        scalefactory= getHeight()/ (HEIGHTBGTOP*1f);
        int sp=canvas.save();
        canvas.scale(scalefactorx,(scalefactory*2/4));
        bg.draw(canvas);
        canvas.restoreToCount(sp);
        canvas.scale(scalefactorx,scalefactory);
        //draw gotas
        for(int i = 0; i< drops.size(); i++){
            drops.get(i).draw(canvas);
        }
        //draw buckets
        for(int i=0;i<buckets.size();i++) {
            buckets.get(i).draw(canvas);
        }
        canvas.restoreToCount(sp);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN) {
            float x = event.getX();
            float y = event.getY();
            if (y < (HEIGHTBGTOP *scalefactory)) {
                if (currentbuckets < maxbuckets) {
                    buckets.add(new Bucket(1, x / scalefactorx, y / scalefactory));
                    currentbuckets++;
                } else {
                    buckets.remove(0);
                    buckets.add(new Bucket(2, x / scalefactorx, y / scalefactory));
                }
            }
        }
        return super.onTouchEvent(event);
    }

}
