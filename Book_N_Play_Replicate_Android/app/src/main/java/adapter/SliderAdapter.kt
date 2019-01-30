package adapter

import android.content.Context
import android.support.v4.view.ViewPager
import android.view.ViewGroup
import android.widget.LinearLayout
import book_n_play_replicate.com.book_n_play_replicate.R.id.textView
import android.widget.TextView
import android.view.LayoutInflater
import android.support.v4.view.PagerAdapter
import android.view.View
import book_n_play_replicate.com.book_n_play_replicate.R


class SliderAdapter(private val context: Context, private val color: List<Int>, private val colorName: List<String>) : PagerAdapter() {

    override fun getCount(): Int {
        return color.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_slider, null)

        val textView = view.findViewById(R.id.textView) as TextView
        val linearLayout = view.findViewById(R.id.linearLayout) as LinearLayout

        textView.text = colorName[position]
        linearLayout.setBackgroundColor(color[position])

        val viewPager = container as ViewPager
        viewPager.addView(view, 0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }
}