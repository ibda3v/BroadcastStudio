package com.ibda3v.broadcaststudio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class MainActivity : AppCompatActivity() {
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // واجهة بسيطة للتجربة
        val playerView = PlayerView(this)
        setContentView(playerView)

        // تجهيز المشغل (Media3)
        player = ExoPlayer.Builder(this).build()
        playerView.player = player
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }
}
