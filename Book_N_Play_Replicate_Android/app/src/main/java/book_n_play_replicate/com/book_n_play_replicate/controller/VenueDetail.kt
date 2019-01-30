package book_n_play_replicate.com.book_n_play_replicate.controller

import adapter.VenuAdapter
import adapter.VenueDetailAdapter
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import book_n_play_replicate.com.book_n_play_replicate.R
import kotlinx.android.synthetic.main.activity_venue_list.*
import model.VenueListModel

class VenueDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue_detail)
        addToolBar()
        addRecyclerView()

        toolbar.setTitle("Venue Detail")
    }


    fun addToolBar(){
        toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbar.navigationIcon?.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    fun addRecyclerView(){
        val layoutManager = LinearLayoutManager(this)
        val adapter = VenueDetailAdapter(this)
        venueRecyclerView.adapter = adapter
        venueRecyclerView.layoutManager = layoutManager
    }



    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
    }
}
