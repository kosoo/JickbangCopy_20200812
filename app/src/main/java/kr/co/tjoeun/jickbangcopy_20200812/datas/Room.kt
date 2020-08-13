package kr.co.tjoeun.jickbangcopy_20200812.datas

import java.io.Serializable
import java.text.NumberFormat

class Room(
    val price : Int,
    val address : String,
    val floor : Int,
    val description : String
) : Serializable {

    fun getFormattedPrice() : String {

        if (this.price >= 10000) {

            val hm = this.price / 10000
            val th = this.price % 10000
            val thStr = NumberFormat.getNumberInstance().format(th)

            return "${hm}억 ${thStr}"

        } else {
            return NumberFormat.getNumberInstance().format(this.price)
        }

    }

}