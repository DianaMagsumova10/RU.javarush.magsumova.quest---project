package com.example.questproject.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionManager {
    public final static Map<Integer, Question> questionList = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        int id = 0;
        questionList.put(++id, new Question(id, "Ты потерял память.\nПринять вызов НЛО?", List.of(
                new Answer("Принять вызов"),
                new Answer("Отклонить вызов", "Ты отклонил вызов. Поражение"))));

        questionList.put(++id, new Question(id, "Ты принял вызов. Поднимаешься на мостик к капитану?", List.of(
                new Answer("Подняться на мостик"),
                new Answer("Откзаться подниматься на мостик", "Ты не пошел на переговоры. Поражение."))));

        questionList.put(++id ,new Question(id, "Ты поднялся на мостик.\nТы кто?", List.of(
                new Answer("Солгать о себе", "Твою ложь разоблачили. Поражение."),
                new Answer("Рассказать правду"))));
    }

    public Question getById(int id) {
        return questionList.get(id);
    }
}
