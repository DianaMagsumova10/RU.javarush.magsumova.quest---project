package com.example.questproject.question;

import lombok.Getter;

@Getter
public class Answer {
    private final String text;
    private final boolean wrongAnswer;

    private String wrongAnswerEndText;

    public Answer(String text, String wrongAnswerEndText) {
        this.text = text;
        this.wrongAnswerEndText = wrongAnswerEndText;
        this.wrongAnswer = true;
    }

    public Answer(String text) {
        this.text = text;
        this.wrongAnswer = false;
    }
}
