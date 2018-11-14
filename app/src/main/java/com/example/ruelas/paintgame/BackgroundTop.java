package com.example.ruelas.paintgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Ruelas on 08/12/2016.
 */
public class BackgroundTop {
    private Bitmap background;
    int sx;
    int sy;
    public BackgroundTop(Context context){
        background= BitmapFactory.decodeResource(context.getResources(),R.drawable.background);
    }
    public void draw(Canvas canvas){
        canvas.drawBitmap(background,0,0,null);
    }
    public void update(){
    }
}
