package com.example.ruelas.paintgame;

import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainGame extends AppCompatActivity implements View.OnClickListener {
    Button btstart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GamePanel gp=new GamePanel(this);
        setContentView(gp);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btstart:
                break;
        }
    }
}
