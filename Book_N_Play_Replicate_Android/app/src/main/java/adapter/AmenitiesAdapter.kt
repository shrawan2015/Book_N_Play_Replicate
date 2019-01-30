package adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import book_n_play_replicate.com.book_n_play_replicate.R
import model.Sport

class AmenitiesAdapter(val context: Context): RecyclerView.Adapter<AmenitiesAdapter.amentiesHolder>() {

    //here we inflate the view and return the viewholder
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): amentiesHolder {
        val inflater =  LayoutInflater.from(context).inflate(R.layout.amenties_subview_cell,parent,false)
        return amentiesHolder(inflater)
    }

    override fun getItemCount(): Int {
        return 12
    }

    //here we bind the object
    override fun onBindViewHolder(viewholder: amentiesHolder, position: Int) {
        viewholder.bindView()
    }

    open inner class amentiesHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val sportImage = itemView.findViewById<ImageView>(R.id.sportImage)
        val sportName = itemView.findViewById<TextView>(R.id.sportName)

        fun bindView(){
//            sportName.text  =  sportCategory.name
        }

    }
}