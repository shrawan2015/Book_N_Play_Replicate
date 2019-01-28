package model

class Sport(val sportID:String, val name:String,val sportPic:String)


object SportsCollection{

    fun sportsList():List<Sport> {
        return ( listOf( Sport("1","Cricket","cricketImage"),
                Sport("1","Tennis","cricketImage"),
                Sport("1","Football","cricketImage"),
                Sport("1","Table Tennis","cricketImage"),
                Sport("1","Shooting","cricketImage"),
                Sport("1","Sopay football","cricketImage"),
                Sport("1","Table Tennis","cricketImage"),
                Sport("1","Basketcall","cricketImage"),
                Sport("1","Paintball","cricketImage"),
                Sport("1","Snooker","cricketImage")
        ))
    }
}