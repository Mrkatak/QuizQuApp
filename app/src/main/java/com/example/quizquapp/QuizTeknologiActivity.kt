package com.example.quizquapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizquapp.databinding.ActivityQuizTeknologiBinding
import io.github.muddz.styleabletoast.StyleableToast

class QuizTeknologiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizTeknologiBinding

    private val question = arrayOf(
        "Apa yang dimaksud dengan URL?",
        "Apa kepanjangan dari JPEG?",
        "Apa istilah yang digunakan untuk menggambarkan perangkat keras dan perangkat lunak yang bekerja bersama-sama untuk memberikan layanan bagi pengguna?",
        "Apa yang dimaksud dengan \"APK\" dalam pengembangan aplikasi mobile?"
    )

    private val options = arrayOf(
        arrayOf("a. Universal Resource Locator", "b. Uniform Resource Locator", "c. Unified Resource Locator"),
        arrayOf("a. Joint Photographic Experts Group", "b. Java Programming Extension Graphics", "c. Jumbo Pixel Enhancement Graphics"),
        arrayOf("a. Hardware", "b. System", "c. Software"),
        arrayOf("a. Android Package Kit", "b. Application Program Kit", "c. Advanced Programming Key")
    )


    private val correctAnswer = arrayOf(0, 0, 1, 0)

    private var currentQuestionIndex = 0
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizTeknologiBinding.inflate(layoutInflater)
        setContentView(binding.root)


        displayQuestion()



        binding.btnOption1.setOnClickListener {
            checkAnswer(0)
        }
        binding.btnOption2.setOnClickListener {
            checkAnswer(1)
        }
        binding.btnOption3.setOnClickListener {
            checkAnswer(2)
        }

        binding.btnRestart.setOnClickListener {
            restartQuiz()
        }

        binding.btnKembali.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun correctBtnColors(buttonIndex: Int) {
        when(buttonIndex){
            0 -> binding.btnOption1.setBackgroundColor(Color.GREEN)
            1 -> binding.btnOption2.setBackgroundColor(Color.GREEN)
            2 -> binding.btnOption3.setBackgroundColor(Color.GREEN)
        }
    }

    private fun wrongBtnColors(buttonIndex: Int) {
        when(buttonIndex){
            0 -> binding.btnOption1.setBackgroundColor(Color.RED)
            1 -> binding.btnOption2.setBackgroundColor(Color.RED)
            2 -> binding.btnOption3.setBackgroundColor(Color.RED)
        }
    }

    private fun resetBtnColors() {
        binding.btnOption1.setBackgroundColor(Color.rgb(50, 59, 96))
        binding.btnOption2.setBackgroundColor(Color.rgb(50, 59, 96))
        binding.btnOption3.setBackgroundColor(Color.rgb(50, 59, 96))
    }

    private fun showResults() {
        StyleableToast.makeText(this, "Your Score : $score out of ${question.size}", Toast.LENGTH_LONG, R.style.mytoast).show()
        //Toast.makeText(this, "Your Score : $score out of ${question.size}", Toast.LENGTH_LONG).show()
        binding.tvScore.text = "Benar $score dari ${question.size} soal"
        binding.btnRestart.isEnabled = true
    }

    private fun displayQuestion() {
        binding.tvQuestion.text = question[currentQuestionIndex]
        binding.btnOption1.text = options[currentQuestionIndex][0]
        binding.btnOption2.text = options[currentQuestionIndex][1]
        binding.btnOption3.text = options[currentQuestionIndex][2]
        resetBtnColors()
    }

    private fun checkAnswer(selectedAnswerIndex: Int) {
        val correctAnswerIndex = correctAnswer[currentQuestionIndex]

        if (selectedAnswerIndex == correctAnswerIndex){
            score++
            correctBtnColors(selectedAnswerIndex)
        }else {
            wrongBtnColors(selectedAnswerIndex)
            correctBtnColors(correctAnswerIndex)
        }

        if (currentQuestionIndex < question.size - 1) {
            currentQuestionIndex++
            binding.tvQuestion.postDelayed({displayQuestion()}, 1500)

        }else{
            showResults()
        }
    }

    private fun restartQuiz(){
        currentQuestionIndex = 0
        score = 0
        displayQuestion()
        binding.btnRestart.isEnabled = false
    }
}