package com.example.ruelas.paintgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by Ruelas on 09/12/2016.
 */
public class Drop extends GameObject {
    int gravity=10;
    int color;
    static int maxcolor=3;
    Paint paint;
    public Drop(int startx, int color){
        x=startx;
        y=0;
        width=10;
        height=10;
        this.color=color;
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
        canvas.drawCircle(x,y,width/2,paint);
    }
    public void update(){
        y+=gravity;
    }
    public void setx(int x) {
        this.x=x;
    }
    public int gety(){
        return y;
    }
}
