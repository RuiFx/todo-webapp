<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>New task ToDo&reg;!</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
</head>
<body>
<div class="container">
    <h1 class="display-6">Let's add a new task ToDo&reg;, ${username}</h1>
    <hr>
    <form:form method="post" modelAttribute="newTaskForm">
        <div class="mb-3">
        <fieldset class="mb-3">
            <form:label path="description" class="form-label">Description</form:label>
            <form:input type="text" path="description" class="form-control" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="targetDate" class="form-label">Target Date</form:label>
            <form:input type="text" path="targetDate" class="form-control" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>
        </div>
        <div class="mb-3">
            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="done"/>
        </div>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <input type="submit" class="btn btn-primary" value="${action}"/>
            <input href="cancel-edit-task" type="submit" class="btn btn-secondary" value="Cancel"/>
        </div>
    </form:form>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'dd-mm-yyyy'
    });
</script>
</body>
</html>