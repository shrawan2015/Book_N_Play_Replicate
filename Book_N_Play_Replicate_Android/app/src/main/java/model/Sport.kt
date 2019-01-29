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


class Venue(var venueID:String,val venueName:String,val venueLocation:String , val distance:Int)

object VenueListModel{
    fun venueList():List<Venue>{

        return ( listOf(
                Venue("1","venuename1","hinjewadi",12),
                Venue("1","venuename2","hinjewadi",12),
                Venue("1","venuename3","hinjewadi",12),
                Venue("1","venuename4","hinjewadi",12),
                Venue("1","venuename5","hinjewadi",12),
                Venue("1","venuename99","hinjewadi",12),
                Venue("1","venuename88","hinjewadi",12),
                Venue("1","venuename67","hinjewadi",12),
                Venue("1","venuename44","hinjewadi",12),
                Venue("1","venuename34","hinjewadi",12),
                Venue("1","venuename66","hinjewadi",12),
                Venue("1","venuename77","hinjewadi",12),
                Venue("1","venuename87","hinjewadi",12),
                Venue("1","venuename76","hinjewadi",12),
                Venue("1","venuename1","hinjewadi",12),
                Venue("1","venuename23","hinjewadi",12)

        )



                )

    }
}