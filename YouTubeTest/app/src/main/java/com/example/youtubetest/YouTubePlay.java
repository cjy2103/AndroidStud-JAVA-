package com.example.youtubetest;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubetest.Adapter.MyAdapter;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class YouTubePlay extends YouTubeBaseActivity
        implements YouTubeView.YouTubeFormListner, View.OnTouchListener{

    /****************************************************************************************************
     ***************************************** 변수 선언단 **********************************************
     ***************************************************************************************************/

    private static final String TAG = YouTubePlay.class.getSimpleName();

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer mYouTubePlayer;
    String videoId = "0-q1KafFCLU";

    private YouTubeView myouTubeView;
    private float mDensity;   //디스플레이 dip?

    private int mOffset;
    private int mOffsetGoal;  // => offsetGoal은 player의 속도에 맞게 ui가 따라가려고 하는 변수?
    private int mFlingVelocity;
    private int mWidth;    //가로 길이

    private int mMaxPos;
    private int mStartPos;   // YouTubeView에서 mSelectionStart 변수로 받는거.
    private int mEndPos;

    private int mPlayEndMsec2; //updatedispaly에서 endpos를 받아 밀리초로 바꾼값을 저장해둘 변수이다.

    private int mPlayEndMsec;     //mPlayEndMsec는 onplay될때 음악이 중지될 지점을 계산해서 저장해둔 변수이다.

    /* 터치 관련 변수 */
    private float mTouchStart;
    private int mTouchInitialOffset;
    private long mYouTubeFormTouchStartMsec;

    private boolean mTouchDragging;



    boolean youTubePlayerFlag = true;
    int deCocount =0;




    /****************************************************************************************************
     ******************************************** onCreate **********************************************
     ***************************************************************************************************/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        init();

    }



    /***************************************************************************************************
     ****************************************** 내부 클래스 ********************************************
     **************************************************************************************************/






    /****************************************************************************************************
     **************************************** 사용자 정의 함수 ******************************************
     ***************************************************************************************************/

    /**
     * @DESC 유튜브 초기화 하는 부분 ( 유튜브 동영상 로드 하는 부분 )
     */
    private void init(){
        youTubePlayerView = findViewById(R.id.youtubeView);

        youTubePlayerView.initialize("develop", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.v(TAG,"유튜브 초기화 성공");
                if(!b){
                    youTubePlayer.cueVideo(videoId);
                }

                youTubePlayer.setShowFullscreenButton(false);
                mYouTubePlayer = youTubePlayer;
                youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT); // 모든 기능 다있음

                youTubePlayer.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
                    @Override
                    public void onLoading() {


                    }

                    @Override
                    public void onLoaded(String s) {

                    }

                    @Override
                    public void onAdStarted() {

                    }

                    @Override
                    public void onVideoStarted() {


                    }

                    @Override
                    public void onVideoEnded() {

                    }

                    @Override
                    public void onError(YouTubePlayer.ErrorReason errorReason) {

                    }
                });

                youTubePlayer.setPlaybackEventListener(new YouTubePlayer.PlaybackEventListener() {
                    @Override
                    public void onPlaying() {
                        youTubePlayerFlag = true;



                    }

                    @Override
                    public void onPaused() {
                        youTubePlayerFlag = false;

                        recyclerView.setNestedScrollingEnabled(true);

                    }

                    @Override
                    public void onStopped() {

                    }

                    @Override
                    public void onBuffering(boolean b) {

                    }

                    @Override
                    public void onSeekTo(int i) {

                    }
                });

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int id = v.getId();
        float att = event.getRawX();
        int action = event.getAction();

        if(action == MotionEvent.ACTION_DOWN){

        } else if (action == MotionEvent.ACTION_MOVE) {

        } else if (action == MotionEvent.ACTION_UP) {

        }
        return false;
    }

    @Override
    public void youTubeformTouchStart(float x) {
        mTouchDragging = true;
        mTouchStart = x;
        mTouchInitialOffset = mOffset;
        mFlingVelocity = 0;
        mYouTubeFormTouchStartMsec = getCurrentTime();
    }

    @Override
    public void youTubeformTouchMove(float x) {

        updateDisplay();

    }

    @Override
    public void youTubeformTouchEnd() {

    }

    private long getCurrentTime(){
        return System.nanoTime() / 1000000;
    }

    private void updateDisplay() {


    }
}
