package book_n_play_replicate.com.book_n_play_replicate.controller

import adapter.SportsCollectionAdapter
import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import book_n_play_replicate.com.book_n_play_replicate.R
import kotlinx.android.synthetic.main.activity_home.*
import model.SportsCollection

import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.graphics.drawable.BitmapDrawable
import android.widget.PopupWindow

import android.view.LayoutInflater
import android.widget.Button
import android.transition.Slide
import android.os.Build

class HomeActivity : AppCompatActivity() {

    lateinit var selectedPoint:Point

    override fun onCreate(savedInstanceState: Bundle?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val slide = Slide()
            slide.slideEdge = Gravity.RIGHT

            window.enterTransition = slide
        }


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sportsList = SportsCollection.sportsList()
        val sportAdapter = SportsCollectionAdapter(this,sportsList)

        var manager = GridLayoutManager(this,3)
        sportsCategory.layoutManager = manager
        sportsCategory.adapter = sportAdapter





        sidemenu.setOnClickListener(){

            val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val layout = layoutInflater.inflate(R.layout.popup_layout, null)

            // Creating the PopupWindow
            val popup = PopupWindow(this)
            popup.setContentView(layout)
//            popup.setWidth(200dp)
//            popup.setHeight(popupHeight)
            popup.setFocusable(true)

            // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
            val OFFSET_X = 0
            val OFFSET_Y = 120

            // Clear the default translucent background
            popup.setBackgroundDrawable(BitmapDrawable())

            // Displaying the popup at the specified location, + offsets.
            popup.showAtLocation(layout, Gravity.NO_GRAVITY, selectedPoint.x + OFFSET_X, selectedPoint.y + OFFSET_Y)


            val logout = layout.findViewById<Button>(R.id.logut)
            logout.setOnClickListener(){
                println("logout is pressed")
                              popup.dismiss()
                openVenuList()

            }

            val mybooking = layout.findViewById<Button>(R.id.mybooking)
            mybooking.setOnClickListener(){
                println("my booking is pressed")

                popup.dismiss()
                openVenuList()

            }

            val resetpassword = layout.findViewById<Button>(R.id.resetpassword)
            resetpassword.setOnClickListener(){
                println("reset password is pressed")

                popup.dismiss()
                openVenuList()

            }


            val myprofile = layout.findViewById<Button>(R.id.myprofile)
            myprofile.setOnClickListener(){
                println("my profile is pressed")

                popup.dismiss()
                openVenuList()
            }




        }
    }


    fun openVenuList(){
        val intent = Intent(this,VenueList::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


    }


     override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        val location = IntArray(2)
        val button = findViewById(R.id.sidemenu) as Button

        // Get the x, y location and store it in the location[] array
        // location[0] = x, location[1] = y.
        button.getLocationOnScreen(location)

        //Initialize the Point with x, and y positions
        selectedPoint = Point()
        selectedPoint.x = location[0]
        selectedPoint.y = location[1]
    }
}
