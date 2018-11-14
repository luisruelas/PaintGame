package com.example.ruelas.paintgame;

import android.graphics.Rect;

/**
 * Created by Ruelas on 09/12/2016.
 */
public abstract class GameObject {
    int x;
    int y;
    int width;
    int height;

    public Rect getRect(){
        return new Rect(x,y,x+width,y+height);
    }
}
