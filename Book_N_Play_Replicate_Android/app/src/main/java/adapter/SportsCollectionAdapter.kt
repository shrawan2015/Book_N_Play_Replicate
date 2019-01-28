package adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import book_n_play_replicate.com.book_n_play_replicate.R
import model.Sport


class SportsCollectionAdapter(val context:Context,val sportsCategoryList:List<Sport>): Adapter<SportsCollectionAdapter.holder>() {

    //here we inflate the view and return the viewholder
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): holder {
        val inflater =  LayoutInflater.from(context).inflate(R.layout.sportlist,parent,false)
        return holder(inflater)
    }

    override fun getItemCount(): Int {
        return sportsCategoryList.count()
    }

    //here we bind the object
    override fun onBindViewHolder(viewholder: holder, position: Int) {
        viewholder.bindView(sportsCategoryList[position])
    }

    open inner class holder(itemView: View): RecyclerView.ViewHolder(itemView){

        val sportImage = itemView.findViewById<ImageView>(R.id.sportImage)
        val sportName = itemView.findViewById<TextView>(R.id.sportName)

        fun bindView(sportCategory:Sport){
            sportName.text  =  sportCategory.name
        }

    }
}