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
import com.example.lessonsFromSamsung.theme45_SQLite.SQLiteActivity
import com.example.lessonsFromSamsung.theme49_ClientServerArchitecture.CatFactActivity
import com.example.lessonsFromSamsung.theme50_RXJava.RXJavaActivity

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
            Theme(clazz = ExercisesWithViews::class.java, title = "Theme 14 ExercisesWithViews"),
            Theme(clazz = FirstPage::class.java, title = "Theme 14 FirstPage"),
            Theme(clazz = QuizActivity::class.java, title = "Theme 14 Quiz"),
            Theme(MainChangeColorActivity::class.java, "Theme 16 ChangingColor"),
            Theme(AuthorizationAndChangingBackgroundColorsActivity::class.java, "Theme 16 AuthorizationScreen"),
            Theme(CashMachine::class.java, "Theme 24 CashMachine"),
            Theme(ServiceActivity::class.java, "Theme 25 MusicPlayService"),
            Theme(PasswordStrength::class.java, "Theme 27 PasswordStrength"),
            Theme(TicTacToe::class.java, "Theme 27 TicTacToe"),
            Theme(GraphicsActivity::class.java, "Theme 27 Drawing"),
            Theme(SurfaceViewActivity::class.java, "Theme 28 SmileDrawing"),
            Theme(TestSurfaceViewActivity::class.java, "Theme 29 DrawingCircle"),
            Theme(RecyclerViewActivity::class.java, "Theme 30_5 ListOfCats"),
            Theme(SQLiteActivity::class.java, "Theme 45 SQLiteActivity"),
            Theme(CatFactActivity::class.java, "Theme 49 InsultsGenerator"),
            Theme(RXJavaActivity::class.java, "Theme 50 RXJava")
        )
    }

    private fun onActivityClick(activity: Theme) {
        val intent = Intent(this, activity.clazz)
        startActivity(intent)
    }
}