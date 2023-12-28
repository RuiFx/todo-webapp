<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>

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
                <td><a href="edit-task?id=${task.id}" title="Edit Task" class="btn btn-success"><i
                        class="fa-regular fa-pen-to-square"></i></a> <a
                        href="delete-task?id=${task.id}" title="Delete Task" class="btn btn-danger"><i
                        class="fa-regular fa-trash-can"></i></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-task" class="btn btn-primary"><i class="fa-solid fa-folder-plus"></i> Add Task</a>
</div>

<%@ include file="common/footer.jsp" %>