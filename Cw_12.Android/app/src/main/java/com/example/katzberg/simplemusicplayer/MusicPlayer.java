package com.example.katzberg.simplemusicplayer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MusicPlayer extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{

    Button playButton;
    SeekBar positionBar;
    SeekBar volumeBar;
    TextView elapseTimeLabel;
    TextView remainingTimeLabel;
    MediaPlayer mediaPlayer;
    int totalTime;
    private GestureDetectorCompat mDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        mDetector=new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);
        playButton=(Button) findViewById(R.id.playButton);
        elapseTimeLabel=(TextView) findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel=(TextView)findViewById(R.id.remainingTimeLabel);

        //MediaPlayer
        mediaPlayer=MediaPlayer.create(this,R.raw.music);
        mediaPlayer.setLooping(true);
        mediaPlayer.seekTo(0);
        mediaPlayer.setVolume(0.5f,0.5f);
        totalTime = mediaPlayer.getDuration();
        //PositionBar
        positionBar = (SeekBar) findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                    positionBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        //VolumeBar
        volumeBar = (SeekBar)findViewById(R.id.volumeBar);
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volumeNum=progress/100f;
                mediaPlayer.setVolume(volumeNum,volumeNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Thread(Update positionBar& timeLabel)
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mediaPlayer!=null) {
                    try{
                        Message msg = new Message();
                        msg.what=mediaPlayer.getCurrentPosition();
                        handler.sendMessage(msg);

                        Thread.sleep(1000);
                    }catch (InterruptedException e){

                    }
                }
            }
        }).start();

    }


    @SuppressLint("HandlerLeak")
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg){
            int currentPosition=msg.what;
            //Update positionBar
            positionBar.setProgress(currentPosition);
            //Update Labels.
            String elapsedTime = createTimeLabel(currentPosition);
            elapseTimeLabel.setText(elapsedTime);

            String remainingTime=createTimeLabel(totalTime-currentPosition);
            remainingTimeLabel.setText("- "+remainingTime);
        }
    };

    public String createTimeLabel(int time){
        String timeLabel="";
        int min = time/1000/60;
        int sec =time/1000%60;
        timeLabel=min+":";
        if(sec<10){
            timeLabel+="0";
        }
        timeLabel+=sec;
        return timeLabel;
    }
    public void playBtnClick(View view){

        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            playButton.setBackgroundResource(R.drawable.stop);

        }
        else {
            // Playing
            mediaPlayer.pause();
            playButton.setBackgroundResource(R.drawable.play);
        }

    }
    public boolean onTouchEvent(MotionEvent event)
    {
        if(this.mDetector.onTouchEvent(event))
        {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {

        Intent goToIntent = new Intent(this,MapsActivity.class);
        startActivity(goToIntent);
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}

