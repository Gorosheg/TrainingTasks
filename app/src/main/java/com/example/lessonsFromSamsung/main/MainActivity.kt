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
import com.example.lessonsFromSamsung.theme25_services.ServiceActivity
import com.example.lessonsFromSamsung.theme25_services.serviceWithRxjava.BtnActivity
import com.example.lessonsFromSamsung.theme27_2Dgraphics.PasswordStrength
import com.example.lessonsFromSamsung.theme27_2Dgraphics.draw.GraphicsActivity
import com.example.lessonsFromSamsung.theme27_2Dgraphics.ticTacToe.TicTacToe
import com.example.lessonsFromSamsung.theme28_SurfaceView.SurfaceViewActivity
import com.example.lessonsFromSamsung.theme29_TestSurfaceView.TestSurfaceViewActivity
import com.example.lessonsFromSamsung.theme30_5_RecyclerView.RecyclerViewActivity
import com.example.lessonsFromSamsung.theme45_SQLite.SQLiteActivity
import com.example.lessonsFromSamsung.theme49_ClientServerArchitecture.CatFactActivity
import com.example.lessonsFromSamsung.theme50_RXJava.RXJavaActivity
import com.example.lessonsFromSamsung.theme52_CleanArc.presentation.TaskActivity

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
            Theme(clazz = ExercisesWithViews::class.java, title = "ExercisesWithViews"),
            Theme(clazz = FirstPage::class.java, title = "GameInterface"),
            Theme(clazz = QuizActivity::class.java, title = "Quiz"),
            Theme(MainChangeColorActivity::class.java, "ChangingColor"),
            Theme(AuthorizationAndChangingBackgroundColorsActivity::class.java, "AuthorizationScreen"),
            Theme(CashMachine::class.java, "CashMachine"),
            Theme(ServiceActivity::class.java, "MusicPlayService"),
            Theme(BtnActivity::class.java, "Service withRx"),
            Theme(PasswordStrength::class.java, "PasswordStrength"),
            Theme(TicTacToe::class.java, "TicTacToe"),
            Theme(GraphicsActivity::class.java, "Drawing"),
            Theme(SurfaceViewActivity::class.java, "SmileDrawing"),
            Theme(TestSurfaceViewActivity::class.java, "DrawingCircle"),
            Theme(RecyclerViewActivity::class.java, "ListOfCats"),
            Theme(SQLiteActivity::class.java, "SQLiteActivity"),
            Theme(CatFactActivity::class.java, "InsultsGenerator"),
            Theme(RXJavaActivity::class.java, "RXJava"),
            Theme(TaskActivity::class.java, "Clean architecture")
        )
    }

    private fun onActivityClick(activity: Theme) {
        val intent = Intent(this, activity.clazz)
        startActivity(intent)
    }
}