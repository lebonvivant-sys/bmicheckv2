<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>BMI Calculator</title>
</head>
<body>
    <h2>BMI Calculator (JSP Version)</h2>
    <form method="post" action="bmicheckv2" id="bmiform">
        Weight (kg): <input type="number" id="weight" name="weight"
        value="${param.weight != null ? param.weight : ''}" /><br><br>
        Height (cm): <input type="number" id="height" name="height"
        value="${param.height != null ? param.height : ''}" /><br><br>
        <button type="submit">Calculate</button>&nbsp;&nbsp;&nbsp;<button type="button" onclick="document.getElementById('weight').value='';document.getElementById('height').value='';document.getElementById('bmi').value=''">Reset</button>
    </form>
    </br>
      <!-- Display the result if present in the request attribute -->
     <c:if test="${not empty resultMessage}">
        <div>
        Result&nbsp;&nbsp;&nbsp;(%):&nbsp;<input type="text" name="bmi" id="bmi" value='${resultMessage}' size="40" readonly /> <br><br>
        </div>
    </c:if>
</body>
</html>
