package com.elliot.randomuserlist.utils

data class RandomUser(
    val name : String = "Elliot",
    val descriptin : String = "Study Hard",
    val profileImage : String = "https://randomuser.me/api/portraits/men/1.jpg"
)

object DummyDataProvider {

    val userList = List<RandomUser>(200){
        RandomUser()
    }

}