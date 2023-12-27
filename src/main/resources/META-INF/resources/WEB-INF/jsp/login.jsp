<html>
<head>
    <title>Do what you have ToDo&reg;! - Login Page</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-sm">
    <h1 class="display-6">Please, login to continue</h1>
    <pre style="color: red">${errorMessage}</pre>
    <form method="post">
        <div class="mb-3">
            <label for="username" class="form-label">Username:</label>
            <input id="username" class="form-control" type="text" name="username">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input id="password" class="form-control" type="password" name="password">
        </div>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button type="submit" class="btn btn-primary">Login</button>
            <button type="reset" class="btn btn-secondary">Cancel</button>
        </div>
    </form>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>