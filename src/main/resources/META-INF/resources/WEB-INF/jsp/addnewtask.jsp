<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>

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
<%@ include file="common/footer.jsp" %>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'dd-mm-yyyy'
    });
</script>
