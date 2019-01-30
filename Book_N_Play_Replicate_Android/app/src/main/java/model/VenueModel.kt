package model


class ImageDetail(val imageList:List<String>)

class RatesOfVenue(val happyhours:String,val weekDays:String, var weekends:String)

class Address(val addressName:String,val longitude:String,val latitude:String)
class Amenities(val ametiesImage:String, val ametiesName:String)

class VenueDetailModel(val imageList:List<String> ,
                       var address:Address ,
                       var aboutUs:String ,
                       var ameties:List<Amenities>,
                       var notes:String,
                       var canellationPolicy:String,
                       var ratesOfVenue: RatesOfVenue)