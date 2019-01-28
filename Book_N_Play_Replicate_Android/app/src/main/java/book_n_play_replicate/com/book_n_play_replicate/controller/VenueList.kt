package book_n_play_replicate.com.book_n_play_replicate.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import book_n_play_replicate.com.book_n_play_replicate.R

class VenueList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue_list)
    }


     override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
    }

}
