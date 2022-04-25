package com.example.jigglypuns

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
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
                    }
                }
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("grayTypeFace")
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