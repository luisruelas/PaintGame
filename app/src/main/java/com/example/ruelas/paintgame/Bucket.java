package com.example.ruelas.paintgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

/**
 * Created by Ruelas on 09/12/2016.
 */
public class Bucket extends GameObject{
    Paint paint;
    static int width;
    static int height;
    public Bucket(int color, double tx, double ty){
        x= (int) tx;
        y= (int) ty;
        super.width=20;
        super.height=20;
        this.width=super.width;
        this.height=super.height;
        paint=new Paint();
        switch (color) {
            case 0:
                paint.setColor(Color.GREEN);
                break;
            case 1:
                paint.setColor(Color.RED);
                break;
            case 2:
                paint.setColor(Color.BLUE);
                break;
        }
    }
    public void draw(Canvas canvas){
        canvas.drawRect((float) (x-(width*GamePanel.scalefactorx)/2), (float) (y-(height*GamePanel.scalefactory)/2),x+width,y+height,paint);
    }
    public void setX(int x){
        super.x=x;
    }
    public void setY(int y){
        super.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void update(){

    }
}
