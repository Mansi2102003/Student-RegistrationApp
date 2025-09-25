<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Registration</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h2>Student Registration Form</h2>
        <form action="register" method="post">
            Name: <input type="text" name="name" required><br>
            Email: <input type="email" name="email" required><br>
            Course: <input type="text" name="course" required><br>
            Age: <input type="number" name="age" required><br>
            Father Name: <input type="text" name="fathername"><br>
            Mother Name: <input type="text" name="mothername"><br>
            12th %: <input type="number" step="0.01" name="twelfth_percentage"><br>
            Address: <textarea name="address"></textarea><br>
            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>
