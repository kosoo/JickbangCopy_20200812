package kr.co.tjoeun.jickbangcopy_20200812

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.jickbangcopy_20200812.adapters.RoomAdapter
import kr.co.tjoeun.jickbangcopy_20200812.datas.Room

class MainActivity : BaseActivity() {

//    화면에 나타날 방들이 담길 배열(목록)
    val mRoomList = ArrayList<Room>()

//    변수는 미리 만들지만, 객체 대임 (초기화)은 나중에 하겠다. 멤버변수
//    리스트뷰에 실제 xml + 데이터객체 조합 -> 뿌려주는 역할 : Adapter
    lateinit var mRoomAdapter : RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        두개의 함수에 적힌 코드는 반드시 onCreate내부에서 실행 시켜줘야 실제로 동작함
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

//        메인 화면의 이벤트 관련 코드 모아둘 장소

        roomListView.setOnItemClickListener { adapterView, view, i, l ->

            val clickedRoom = mRoomList[i]

            val myIntent = Intent(mContext, ViewRoomDetailActivity::class.java)

            myIntent.putExtra("roomInfo", clickedRoom)
            startActivity(myIntent)

        }
    }

    override fun setValues() {

//        메인 화면의 값 출력 관련 코드 모아둘 장소

//        방 목록을 강제로 추가하는 코드
        mRoomList.add(Room(8500, "서울시 은평구", 5, "은평구의 5층 방입니다."))
        mRoomList.add(Room(78000, "서울시 은평구", 3, "은평구의 3층 방입니다."))
        mRoomList.add(Room(2400, "서울시 은평구", 0, "은평구의 반지하 방입니다."))
        mRoomList.add(Room(23500, "서울시 서대문구", -1, "서대문구의 지하1층 방입니다."))
        mRoomList.add(Room(17500, "서울시 서대문구", 4, "서대문구의 4층 방입니다."))
        mRoomList.add(Room(55000, "서울시 서대문구", 7, "서대문구의 7층 방입니다."))
        mRoomList.add(Room(9600, "서울시 동대문구", 0, "동대문구의 반지하 방입니다."))
        mRoomList.add(Room(38000, "서울시 동대문구", 11, "동대문구의 11층 방입니다."))
        mRoomList.add(Room(57000, "서울시 동대문구", 12, "동대문구의 12층 방입니다."))
        mRoomList.add(Room(85000, "서울시 동대문구", 15, "동대문구의 15층 방입니다."))

//        초기화를 미뤄둔 어댑터를 실제로 초기화하자
        mRoomAdapter = RoomAdapter(mContext, R.layout.room_list_item, mRoomList)

        roomListView.adapter = mRoomAdapter
    }
}