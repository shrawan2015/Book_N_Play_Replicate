package book_n_play_replicate.com.book_n_play_replicate.controller

import adapter.VenuAdapter
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import book_n_play_replicate.com.book_n_play_replicate.R
import kotlinx.android.synthetic.main.activity_venue_list.*
import kotlinx.android.synthetic.main.venue_cell.*
import model.VenueListModel

class VenueList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue_list)
        addToolBar()
        addRecyclerView()
    }

    fun bookTicket(){
        bookVenue.setOnClickListener(){
            openVenuList()
        }
    }

    fun openVenuList(){
        val intent = Intent(this,VenueDetail::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }


    fun addToolBar(){
        toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbar.navigationIcon?.setColorFilter(Color.GRAY,PorterDuff.Mode.SRC_ATOP)

        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    fun addRecyclerView(){
        var venuAdapter = VenuAdapter(this,VenueListModel.venueList()){
            bookTicket()
        }
        venueRecyclerView.adapter = venuAdapter

        val layoutManager = LinearLayoutManager(this)
        venueRecyclerView.layoutManager = layoutManager
    }



     override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
    }

}
