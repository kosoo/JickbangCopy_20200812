package kr.co.tjoeun.jickbangcopy_20200812.datas

import java.io.Serializable
import java.text.NumberFormat

// 생성자 - Room을 만들때 필수적으로 넣어줘야할 정보 항목들을 명시하자. (가격, 주소, 층수, 설명)
// : Serializable - Room을 통째로 putExtra / getExtra 해주기 위해 필요한 코드
class Room(
    val price : Int,
    val address : String,
    val floor : Int,
    val description : String
) : Serializable {
    
//    가격을 상황별로 가공해서 String 으로 주는 기능
    fun getFormattedPrice() : String {

//        1억이 넘는지 아닌 구별, 상황별로 다르게 가공된 문장을 리턴(결과로 지정)
        if (this.price >= 10000) {

//            몇억? 만으로 나눈 몫 = 억단위
            val hm = this.price / 10000
//            나머지 만원단위 => 15400 : 5400? 만으로 나눈 나머지값.
            val th = this.price % 10000
//            구해진 만원 단위 => 세자리마다 컴마 찍기
            val thStr = NumberFormat.getNumberInstance().format(th)

//            ?억 ?(세자리콤마) 양식으로 가공
            return "${hm}억 ${thStr}"

        } else {
//            7500 => 7,500 처럼 세자리마다 , 찍어주는 기능 활용
            return NumberFormat.getNumberInstance().format(this.price)
        }

    }

//    층수 (Int) 를 상황별로 가공해서 String으로 만들어주는 기능
    fun getFormattedFloor() : String {

//        최종 가공 결과가 저장될 변수를 미리 만들자 
        val floorStr : String
    
//        층수가 1이상, 0, 그외 상황에 따라 다르게 가공 - 조건문
        if (this.floor >= 1) {
//            ?층 형태로 가공
            floorStr = "${this.floor}층"
        } else if (this.floor == 0) {
//            0층은 무조건 반지하로 출력
            floorStr = "반지하"
        } else {
//            지하 ?층 형태로 가공
//            this.floor가 음수이므로 양수로 바꾸기 위한 - 첨부
            floorStr = "지하 ${-this.floor}층"
        }

//        완성된 문구를 이함수의 결과로 지정 (return)
        return floorStr
    }

}