<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>New task ToDo&reg;!</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <h1 class="display-6">Let's add a new task ToDo&reg;, ${description}</h1>
    <hr>

    <form:form method="post" modelAttribute="newTaskForm">
        <div class="mb-3">
        <form:errors path="description" cssClass="error"/>
        </div>
        <div class="mb-3">
            <form:input class="form-control" type="hidden" path="id" required="true"/>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description:</label>
            <form:input id="description" class="form-control" type="text" name="description" path="description" required="true"/>
            <form:errors path="description" cssClass="error"/>
        </div>
        <!--<div class="mb-3">
            <label for="targetDate" class="form-label">Target date:</label>
            <input id="targetDate" class="form-control" type="datetime-local" name="id">
        </div>-->
        <div class="mb-3">
            <form:input type="hidden" class="form-control" path="done"/>
        </div>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button type="submit" class="btn btn-primary">${action}</button>
            <button type="reset" class="btn btn-secondary">Cancel</button>
        </div>
    </form:form>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>