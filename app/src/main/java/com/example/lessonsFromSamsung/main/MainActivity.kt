package com.example.lessonsFromSamsung.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.main.model.Theme
import com.example.lessonsFromSamsung.main.recycler.MainAdapter
import com.example.lessonsFromSamsung.theme14_InterfaceOfAndroidAplication.ExercisesWithViews
import com.example.lessonsFromSamsung.theme14_InterfaceOfAndroidAplication.gameInterface.FirstPage
import com.example.lessonsFromSamsung.theme14_InterfaceOfAndroidAplication.qize.QuizActivity
import com.example.lessonsFromSamsung.theme16_TestingAndDebugging.AuthorizationAndChangingBackgroundColorsActivity
import com.example.lessonsFromSamsung.theme16_TestingAndDebugging.color.MainChangeColorActivity
import com.example.lessonsFromSamsung.theme24_Threads.atm.CashMachine
import com.example.lessonsFromSamsung.theme25_Services.ServiceActivity
import com.example.lessonsFromSamsung.theme27_2Dgraphics.PasswordStrength
import com.example.lessonsFromSamsung.theme27_2Dgraphics.draw.GraphicsActivity
import com.example.lessonsFromSamsung.theme27_2Dgraphics.ticTacToe.TicTacToe
import com.example.lessonsFromSamsung.theme28_SurfaceView.SurfaceViewActivity
import com.example.lessonsFromSamsung.theme29_TestSurfaceView.TestSurfaceViewActivity
import com.example.lessonsFromSamsung.theme30_5_RecyclerView.RecyclerViewActivity
import com.example.lessonsFromSamsung.theme49_ClientServerArchitecture.CatFactActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.mainRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = MainAdapter(
            activities = buildList(),
            onActivityClickListener = ::onActivityClick
        )
    }


    private fun buildList(): List<Theme> {
        return listOf(
            Theme(clazz = ExercisesWithViews::class.java, title = "Theme14 ExercisesWithViews"),
            Theme(clazz = FirstPage::class.java, title = "Theme14 FirstPage"),
            Theme(clazz = QuizActivity::class.java, title = "Theme14 Quiz"),
            Theme(MainChangeColorActivity::class.java, "Theme16 ChangingColor"),
            Theme(AuthorizationAndChangingBackgroundColorsActivity::class.java, "Theme16 AuthorizationScreen"),
            Theme(CashMachine::class.java, "Theme24 CashMachine"),
            Theme(ServiceActivity::class.java, "Theme 25 MusicPlayService"),
            Theme(PasswordStrength::class.java, "Theme27 PasswordStrength"),
            Theme(TicTacToe::class.java, "Theme27 TicTacToe"),
            Theme(GraphicsActivity::class.java, "Theme27 Drawing"),
            Theme(SurfaceViewActivity::class.java, "Theme28 SmileDrawing"),
            Theme(TestSurfaceViewActivity::class.java, "Theme29 DrawingCircle"),
            Theme(RecyclerViewActivity::class.java, "Theme30_5 ListOfCats"),
            Theme(CatFactActivity::class.java, "Theme49 InsultsGenerator")
        )
    }

    private fun onActivityClick(activity: Theme) {
        val intent = Intent(this, activity.clazz)
        startActivity(intent)
    }
}