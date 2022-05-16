package com.yuneec.videostreaming

import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val url = "rtsp://192.168.0.105:1554"
    private lateinit var player: RTSPPlayer
    private lateinit var surfaceView: SurfaceView
    private lateinit var holder: SurfaceHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        surfaceView = findViewById(R.id.video_view_container)
        player = RTSPPlayer()
        player.initializePlayer()
        holder = surfaceView.holder
    }

    override fun onStart()
    {
        super.onStart()

        player.setDataSource(url)
        player.setDisplay(holder)

        player.start()
    }

    override fun onStop()
    {
        super.onStop()
        player.stop()
    }

    override fun onDestroy()
    {
        super.onDestroy()
        player.releasePlayer()
    }

}