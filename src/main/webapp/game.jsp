<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quest Game</title>
    <link href="css/game.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="https://code.jquery.com/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<h1>${question.getText()}</h1>

<c:if test="${question != null}">
    <table>
        <c:forEach var="i" begin="0" end="${question.getAnswerList().size() - 1}">
            <tr>
                <td>
                    <button onclick="window.location='/game?answerId=${i}'">
                        <c:out value="${question.getAnswerList().get(i).getText()}"/>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${question == null}">
    <c:if test="${wrongAnswer != null}">
        <h1>${wrongAnswer.getWrongAnswerEndText()}</h1>
    </c:if>
    <c:if test="${wrongAnswer == null}">
        <h1>Тебя вернули домой</h1>
    </c:if>
    <button onclick="window.location='/restart'" class="button button1">Начать заново</button>
</c:if>

</body>
</html>