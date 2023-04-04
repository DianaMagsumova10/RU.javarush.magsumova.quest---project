import com.example.questproject.question.Answer;
import com.example.questproject.question.Question;
import com.example.questproject.question.QuestionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuestionsTest {
    QuestionManager questionManager = new QuestionManager();

    @Test
    public void getByIdTest() {
        int questionId = 1;
        Question question = questionManager.getById(questionId);
        Assertions.assertEquals(questionId, question.getId());
    }

    @Test
    public void allTestHaveAnswersAndOnlyOneIsRight() {
        boolean result = true;
        for (Question question : QuestionManager.questionList.values()) {
            if (question != null && question.getAnswerList().size() > 0) {
                int rightAnswerCount = 0;
                for(Answer answer : question.getAnswerList()) {
                    if (!answer.isWrongAnswer()) {
                        rightAnswerCount++;
                    } else {
                        if (answer.getWrongAnswerEndText() == null) {
                            result = false;
                            break;
                        }
                    }
                }
                if (rightAnswerCount > 1) {
                    result = false;
                    break;
                }
            } else {
                result = false;
                break;
            }
        }
        Assertions.assertTrue(result);
    }

}
