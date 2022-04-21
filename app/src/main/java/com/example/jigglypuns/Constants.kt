package com.example.jigglypuns

object Constants {

    fun getQuestions(): ArrayList<Question> {

        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What you would say when your caught doing something bad",
            R.drawable.jigglypuff,
            "The Jigglypuff is up",
            "Oh snap, my mom Jigglypuff me",
            "I'm about to Jigglypuff",
            "quick, Jigglypuff, RUN!",
            1
        )

        questionsList.add(que1)

        val que2 = Question(
            2,
            "what are you when you work out at the gym?",
            R.drawable.jigglypuff,
            "Jigglycool",
            "Epicpuff",
            "Strongpuff",
            "Jigglybuff",
            4
        )

        questionsList.add(que2)

        val que3 = Question(
            3,
            "When you are the imposter",
            R.drawable.jigglypuff,
            "Suspuff",
            "Jigglesus",
            "Susspuff",
            "Jigglysus",
            4
        )

        questionsList.add(que3)

        val que4 = Question(
            4,
            "No Jigglypuff?",
            R.drawable.jigglypuff,
            "Jigglysus",
            "Desperately seeking Jigglypuff",
            "Jigglycomeback",
            "Jigglyno",
            2
        )

        questionsList.add(que4)

        val que5 = Question(
            5,
            "how good is your RNG?",
            R.drawable.jigglypuff,
            "Jigglypuff",
            "Jigglypuff",
            "Jigglypuff",
            "Jigglypuff",
            3
        )

        questionsList.add(que5)

        val que6 = Question(
            6,
            "Question 1",
            R.drawable.jigglypuff,
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
            1
        )

        questionsList.add(que6)

        val que7 = Question(
            7,
            "Question 1",
            R.drawable.jigglypuff,
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
            1
        )

        questionsList.add(que7)

        val que8 = Question(
            8,
            "Question 1",
            R.drawable.jigglypuff,
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
            1
        )

        questionsList.add(que8)

        val que9 = Question(
            9,
            "Question 1",
            R.drawable.jigglypuff,
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
            1
        )

        questionsList.add(que9)

        val que10 = Question(
            10,
            "Question 1",
            R.drawable.jigglypuff,
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
            1
        )

        questionsList.add(que10)

        return questionsList
    }
}