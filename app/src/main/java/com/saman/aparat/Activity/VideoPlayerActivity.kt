package com.saman.aparat.Activity



import android.app.DownloadManager
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.saman.aparat.R
import com.saman.aparat.databinding.ActivityVideoPlayerBinding
import com.saman.aparat.db.AppDatabase
import com.saman.aparat.models.Video


class VideoPlayerActivity : AppCompatActivity() {

    lateinit var binding: ActivityVideoPlayerBinding
    lateinit var exoPlayer: ExoPlayer
    lateinit var bundle: Bundle
    lateinit var video: Video

    lateinit var myDB: AppDatabase

    ////////////////////////////////////////////////////////////////////

var myDownloadId:Long=0
    lateinit var manager: DownloadManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDB = AppDatabase.getInstance(applicationContext)

        bundle = intent.extras!!
        video = bundle.getParcelable<Video>("video")!!


        binding.txtTitle1.setText(video.title)
        binding.txtTitle2.setText(video.title)
        binding.txtView.setText(video.view)
        binding.txtDesc.setText(video.description)
        exoPlayer = ExoPlayer.Builder(applicationContext).build()

        val mediaItem = MediaItem.fromUri(Uri.parse(video.link))
        with(exoPlayer) {
            setMediaItem(mediaItem)
            prepare()
            play()
        }
        binding.videoView.player = exoPlayer

        binding.arrowBack.setOnClickListener({
            finish()
        })



        binding.keyboardArrow.setOnClickListener {
            if (binding.expandableDesc.visibility == View.GONE) {
                binding.expandableDesc.visibility = View.VISIBLE
                binding.keyboardArrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
            } else {
                binding.keyboardArrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                binding.expandableDesc.visibility = View.GONE
                binding.keyboardArrow.setImageResource(R.drawable.keyboard_arrow_down)
            }

        }

        binding.iconShare.setOnClickListener {
            val intent1 = Intent(Intent.ACTION_SEND)
            intent1.type = "text/plain"
            intent1.putExtra(Intent.EXTRA_SUBJECT, "share my message")
            intent1.putExtra(Intent.EXTRA_TEXT, "share")
            startActivity(Intent.createChooser(intent1, "share"))
        }


        if (myDB.idao().isRowIsExist(video.id.toInt())) {

            binding.favoriteBorder.setImageResource(R.drawable.ic_baseline_favorite)

        } else {
            binding.favoriteBorder.setImageResource(R.drawable.favorite_border)

        }

        binding.downloadImg.setOnClickListener {
            var request:DownloadManager.Request=DownloadManager.Request(
                Uri.parse(video.link)).setTitle(video.title).setDescription("is downloading")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)

                .setAllowedOverMetered(true)
                .setAllowedOverRoaming(true)
                .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE )
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,video.title)


            var dm:DownloadManager=getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            myDownloadId=dm.enqueue(request)

        }

        var br=object:BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                var id:Long?= p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1)
                if(id==myDownloadId){
                    Toast.makeText(applicationContext,"completed successfully",Toast.LENGTH_LONG).show()
                }

            }
        }
        registerReceiver(br, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))





        binding.favoriteBorder.setOnClickListener {
            if (!myDB.idao().isRowIsExist(video.id.toInt())) {
                myDB.idao().insert(video)
                binding.favoriteBorder.setImageResource(R.drawable.ic_baseline_favorite)
                //Toast
                Toast.makeText(applicationContext, getString(R.string.addedToList), Toast.LENGTH_SHORT).show()
            } else {
                myDB.idao().Delete(video.id.toInt())
                binding.favoriteBorder.setImageResource(R.drawable.favorite_border)
                Toast.makeText(applicationContext, getString(R.string.removeFromList), Toast.LENGTH_SHORT).show()
            }
        }

    }


    override fun onStop() {

        if (exoPlayer.isPlaying || exoPlayer != null) {
            exoPlayer.stop()
        }
        super.onStop()
    }



}





