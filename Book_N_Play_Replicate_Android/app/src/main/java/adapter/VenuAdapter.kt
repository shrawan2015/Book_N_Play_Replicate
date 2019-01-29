package adapter
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import book_n_play_replicate.com.book_n_play_replicate.R
import model.Venue

class VenuAdapter(val context: Context,val venueList:List<Venue> , val itemClick: (Venue) -> Unit): RecyclerView.Adapter<VenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parentView: ViewGroup, position: Int):ViewHolder {
        val inflateview =  LayoutInflater.from(context).inflate(R.layout.venue_cell,parentView,false)
        return  ViewHolder(context,itemView = inflateview , itemClick = itemClick )
    }

    override fun getItemCount(): Int {
        return  venueList.count()
    }

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
        viewholder.bindObject(venueList[position]  )
    }


    inner class ViewHolder(context:Context,itemView: View , val itemClick: (Venue) -> Unit): RecyclerView.ViewHolder(itemView){

        val venueName = itemView.findViewById<TextView>(R.id.venueName)
        val bookVenue = itemView.findViewById<Button>(R.id.bookVenue)
        fun bindObject(venue:Venue){
            venueName.text = venue.venueName

            bookVenue.setOnClickListener{itemClick(venue)}
        }


    }
}