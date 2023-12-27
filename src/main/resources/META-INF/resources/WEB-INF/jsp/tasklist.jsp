<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Do what you have ToDo&reg;!</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="display-6">Welcome to your ToDo&reg; dashboard, ${username}</h1>
    <hr>
    <table class="table table-light table-striped">
        <thead>
        <tr class="table-dark">
            <th>Description</th>
            <th>Target Date</th>
            <th>It is Done?</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.description}</td>
                <td>${task.targetDate}</td>
                <td>${task.done}</td>
                <td><a href="edit-task?id=${task.id}" class="btn btn-success">Edit task</a> <a href="delete-task?id=${task.id}" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-task" class="btn btn-primary"><i class="fa-solid fa-clipboard"></i> Add Task</a>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>