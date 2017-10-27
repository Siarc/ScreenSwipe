package com.example.aminu.swipetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.TextView;
import android.view.MotionEvent;
import android.widget.Button;
import android.support.v4.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener{

    private TextView arcView;
    private Button arcButton;
    private GestureDetectorCompat arcGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arcButton=(Button)findViewById(R.id.arcButton);

        arcButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView arcView=(TextView)findViewById(R.id.arcText);
                        arcView.setText("You Just Tapped Me!");
                    }
                }
        );
        arcButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        TextView arcView=(TextView)findViewById(R.id.arcText);
                        arcView.setText("I Am Tapped On!");
                        return false;
                    }
                }
        );

        arcView=(TextView)findViewById(R.id.arcText);
        this.arcGestureDetector= new GestureDetectorCompat(this,this);
        arcGestureDetector.setOnDoubleTapListener(this);
    }



    //// Gestures ////
    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        arcView.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        arcView.setText("onDoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        arcView.setText("onDoubleTapEvent");
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        arcView.setText("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        arcView.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        arcView.setText("onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        arcView.setText("onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        arcView.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        arcView.setText("onFling");
        return false;
    }
    ///  Gestures Ends////

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.arcGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
