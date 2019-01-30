package adapter
import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.GridLayoutManager
import book_n_play_replicate.com.book_n_play_replicate.R
import book_n_play_replicate.com.book_n_play_replicate.R.id.sportsCategory
import kotlinx.android.synthetic.main.activity_home.*
import model.SportsCollection

class VenueDetailAdapter(val context:Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var recyclerViewHolder:RecyclerView.ViewHolder

        if (viewType == 0 ){
            val holder = LayoutInflater.from(context).inflate(R.layout.venue_image_cell,parent,false)
            recyclerViewHolder =  VenuImage(holder)
        }else if (viewType == 3){
            val holder = LayoutInflater.from(context).inflate(R.layout.venue_notes_policy_cell,parent,false)
            recyclerViewHolder =  VenuePolicyViewHolder(holder,context)
        }else if (viewType == 1){
            val holder = LayoutInflater.from(context).inflate(R.layout.about_us_cell,parent,false)
            recyclerViewHolder =  AboutUsViewHolder(holder,context)
        }else if (viewType == 2){
            val holder = LayoutInflater.from(context).inflate(R.layout.amenities_cell,parent,false)
            recyclerViewHolder =  AmmentiesViewHolder(holder,context)
        }else{
            val holder = LayoutInflater.from(context).inflate(R.layout.venue_cell,parent,false)
            recyclerViewHolder =  VenuDetailHolder2(holder,context)
        }

        return recyclerViewHolder

    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, p1: Int) {

        val viewType =  holder.itemViewType

       when(holder){
           is VenuImage -> holder.bindObject(context)
           is AmmentiesViewHolder -> holder.bindObject()
           is VenuePolicyViewHolder -> holder.bindObject()
       }
    }


    override fun getItemViewType(position: Int): Int {
            return position
    }

    inner class VenuImage(itemView: View? ): RecyclerView.ViewHolder(itemView!!) {

        val viewPager  = itemView?.findViewById<ViewPager>(R.id.viewPager)
        val indicator = itemView?.findViewById<TabLayout>(R.id.indicator)

        fun bindObject(context: Context){
            val color: List<Int>
            val colorName: List<String>
            color = ArrayList()
            color.add(Color.RED)
            color.add(Color.GREEN)
            color.add(Color.BLUE)

            colorName = ArrayList()
            colorName.add("RED")
            colorName.add("GREEN")
            colorName.add("BLUE")

            viewPager?.adapter = SliderAdapter(context, color, colorName)
            indicator?.setupWithViewPager(viewPager, true)

        }
    }

    inner class VenuDetailHolder2(itemView: View, val context: Context): RecyclerView.ViewHolder(itemView) {
        fun bindObject(){}
    }


    inner class AboutUsViewHolder(itemView: View, val context: Context): RecyclerView.ViewHolder(itemView) {
        fun bindObject(){}
    }

    inner class AmmentiesViewHolder(itemView: View, val context: Context): RecyclerView.ViewHolder(itemView) {

        val recyclerView  = itemView.findViewById<RecyclerView>(R.id.amenties_recycler_view)

        fun bindObject(){

            val sportAdapter = AmenitiesAdapter(context)

            var manager = GridLayoutManager(context,2)
            recyclerView.layoutManager = manager
            recyclerView.adapter = sportAdapter

        }
    }

    inner class VenuePolicyViewHolder(itemView: View, val context: Context): RecyclerView.ViewHolder(itemView) {


        fun bindObject(){


        }
    }
}