<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>

<div class="container">
    <h1 class="display-6">Welcome to your ToDo&reg; dashboard, ${username}</h1>
    <hr>
    <a class="btn btn-success" href="task-list"><i class="fa-solid fa-clipboard-list"></i> Manage tasks!</a>
    <hr>
    <figure>
        <blockquote class="blockquote">
            <p>"It Is The Quality Of One's Convictions That Determines Success, Not The Number of Followers."</p>
        </blockquote>
        <figcaption class="blockquote-footer">
            Remus Lupin <cite title="Source Title">Hogwarts School</cite>
        </figcaption>
    </figure>
</div>

<%@ include file="common/footer.jsp" %>