package com.alanlyne.tbm.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.Variables.Var;

public class video extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoView = findViewById(R.id.video_view);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/videoview-247213.appspot.com/o/Video.mp4?alt=media&token=d049cc83-5635-487d-ac48-1a36d5b64844");

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);

        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent menu = new Intent(video.this, Menu.class);
                startActivity(menu);
            }
        });

    }
}
