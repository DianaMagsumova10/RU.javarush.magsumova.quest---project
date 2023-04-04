package com.example.questproject;

import java.io.*;

import com.example.questproject.question.Answer;
import com.example.questproject.question.Question;
import com.example.questproject.question.QuestionManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession();
        QuestionManager questionManager = new QuestionManager();
        Question currentQuestion = getCurrentQuestion(req);
        Question nextQuestion = null;
        if (currentQuestion == null) {
            nextQuestion = questionManager.getById(1);
        } else {
            Answer currentAnswer = getCurrentAnswer(currentQuestion, req);
            if (currentAnswer != null && !currentAnswer.isWrongAnswer()) {
                nextQuestion = questionManager.getById(currentQuestion.getId() + 1);
            } else {
                currentSession.setAttribute("wrongAnswer", currentAnswer);
            }
        }
        currentSession.setAttribute("question", nextQuestion);
        resp.sendRedirect("/game.jsp");
    }
    private Question getCurrentQuestion(HttpServletRequest req) {
        try {
            return (Question) req.getSession().getAttribute("question");
        } catch (Exception e) {
            return null;
        }
    }
    private Answer getCurrentAnswer(Question currentQuestion, HttpServletRequest req) {
        try {
            int answerId = Integer.parseInt(req.getParameter("answerId"));
            return currentQuestion.getAnswerList().get(answerId);
        } catch (Exception e) {
            return null;
        }
    }
}