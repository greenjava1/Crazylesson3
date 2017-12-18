package com.mycompany.crazylesson3;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private int speed = 10;
    //EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
       // Button bt = (Button) findViewById(R.id.button1);
       // bt.setOnClickListener(new MyClickListener(this));
        //
        final PlaneView planeView = new PlaneView(this);
        setContentView(planeView);
       // planeView.setBackground(R.drawable.back);
        WindowManager windowManager = getWindowManager();
        Display display  = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();

        display.getMetrics(metrics);
        planeView.currentX = metrics.widthPixels/2;
        planeView.currentY = metrics.widthPixels/2;
        planeView.str="hello";



        planeView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.KEYCODE_S:
                        planeView.currentY+=speed;
                        break;
                    case KeyEvent.KEYCODE_W:
                        planeView.currentY-=speed;
                        break;
                    case KeyEvent.KEYCODE_A:
                        planeView.currentX-=speed;
                        break;
                    case KeyEvent.KEYCODE_D:
                        planeView.currentX+=speed;
                        break;
                }
                planeView.invalidate();
                return true;
            }
        });
        planeView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        planeView.currentX = event.getX();
                        planeView.currentY = event.getY();
                        planeView.str = "起始位置为：" + "(" + event.getX() + " , " + event.getY() + ")";
                        break;
                    case MotionEvent.ACTION_MOVE:
                        planeView.currentX = event.getX();
                        planeView.currentY = event.getY();
                        planeView.str  = "移动中坐标为：" + "(" + event.getX() + " , " + event.getY() + ")";
                        break;
                    case MotionEvent.ACTION_UP:
                        planeView.currentX = event.getX();
                        planeView.currentY = event.getY();
                        planeView.str  = "最后位置为：" + "(" + event.getX() + " , " + event.getY() + ")";
                }
                planeView.invalidate();
                return true;
            }
            });

    }
}
class MyClickListener implements  View.OnClickListener
{
    private final String TAG = "MyClickListener";
    private Context myContext;
    public MyClickListener(Context context)
    {
        myContext = context;

    }
    @Override
    public void onClick(View v)
    {
        Log.v(TAG, "MyClickListener");
        Toast.makeText(myContext,"hello world",Toast.LENGTH_LONG).show();

    }
}

