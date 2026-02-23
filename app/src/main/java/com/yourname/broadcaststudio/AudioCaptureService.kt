package com.yourname.broadcaststudio

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioPlaybackCaptureConfiguration
import android.media.AudioRecord
import android.os.IBinder

class AudioCaptureService : Service() {

    // هذا الكود مخصص لجمع الصوت وتحويله لمسار الـ MIC
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // إعدادات التقاط الصوت من التطبيق (داخلياً)
        val config = AudioPlaybackCaptureConfiguration.Builder(MediaProjectionHolder.mediaProjection!!)
            .addMatchingUsage(AudioAttributes.USAGE_MEDIA)
            .build()

        val recorder = AudioRecord.Builder()
            .setAudioPlaybackCaptureConfig(config)
            .setAudioFormat(AudioFormat.Builder()
                .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                .setSampleRate(44100)
                .setChannelMask(AudioFormat.CHANNEL_IN_STEREO)
                .build())
            .build()

        recorder.startRecording()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
