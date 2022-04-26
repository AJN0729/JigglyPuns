package com.example.jigglypuns

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var tvImage: ImageView? = null
    private var tvOptionsOne: TextView? = null
    private var tvOptionsTwo: TextView? = null
    private var tvOptionsThree: TextView? = null
    private var tvOptionsFour: TextView? = null
    private var buttonSubmit: Button? = null

    private var mCurrentPosition = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mCorrectAnswers = 0
    private var mUserName: String? = null
    private var mSelectedOptionPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        tvImage = findViewById(R.id.iv_image)
        tvOptionsOne = findViewById(R.id.tv_option_one)
        tvOptionsTwo = findViewById(R.id.tv_option_two)
        tvOptionsThree = findViewById(R.id.tv_option_three)
        tvOptionsFour = findViewById(R.id.tv_option_four)
        buttonSubmit = findViewById(R.id.btn_submit)
        mQuestionsList = Constants.getQuestions()

        setQuestion()

        tvOptionsOne?.setOnClickListener(this)
        tvOptionsTwo?.setOnClickListener(this)
        tvOptionsThree?.setOnClickListener(this)
        tvOptionsFour?.setOnClickListener(this)
        buttonSubmit?.setOnClickListener(this)
    }

    private fun setQuestion() {
        val question: Question =
            mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size) {
            buttonSubmit?.text = "FINISH"
        } else {
            buttonSubmit?.text = "SUBMIT"
        }

        progressBar?.progress = mCurrentPosition!!
        tvProgress?.text = "$mCurrentPosition" + "/" + progressBar?.max

        tvQuestion?.text = question.question
        tvImage?.setImageResource(question.image)
        tvOptionsOne?.text = question.optionOne
        tvOptionsTwo?.text = question.optionTwo
        tvOptionsThree?.text = question.optionThree
        tvOptionsFour?.text = question.optionFour
    }

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        tvOptionsOne?.let {
            options.add(0, it)
        }
        tvOptionsTwo?.let{
            options.add(1, it)
        }
        tvOptionsThree?.let{
            options.add(2, it)
        }
        tvOptionsFour?.let{
            options.add(3, it)
        }

        for (option in options) {
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizQuestionActivity,
                R.drawable.default_option_border
            )
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.tv_option_one -> {
                tvOptionsOne?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.tv_option_two -> {
                tvOptionsTwo?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.tv_option_three -> {
                tvOptionsThree?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.tv_option_four -> {
                tvOptionsFour?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btn_submit -> {

                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++

                    when {

                        mCurrentPosition <= mQuestionsList!!.size -> {
                         
                            setQuestion()
                        }
                        else -> {
                            val intent =
                                Intent(this@QuizQuestionActivity, ResultsActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mQuestionsList?.size)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    } else {
                        mCorrectAnswers++
                    }

                    answerView(question.correctAnswer, R.drawable.correct_option_border)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        buttonSubmit?.text = "FINISH"
                    } else {
                        buttonSubmit?.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionActivity,
            R.drawable.selected_option_border
        )
    }

    private fun answerView(answer: Int, drawable: Int) {
        when (answer) {
            1 -> {
                tvOptionsOne?.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawable
                )
            }

            2 -> {
                tvOptionsTwo?.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawable
                )

            }

            3 -> {
                tvOptionsThree?.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawable
                )
            }

            4 -> {
                tvOptionsFour?.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawable
                )
            }
        }
    }

}