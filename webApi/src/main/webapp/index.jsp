<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration Form</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div id="ab">

    <div id="a">
        <div class="container" id="a1">
            <h1>Student Registration Form</h1>
            <form id="registrationForm">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="dob">Date of Birth</label>
                    <input type="date" id="dob" name="dob" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="tel" id="phone" name="phone" required>
                </div>
                <div class="form-group">
                    <label for="city">City</label>
                    <input type="text" id="city" name="city" required>
                </div>
                <div class="form-group">
                    <label for="department">Department</label>
                    <input type="text" id="department" name="department" required>
                </div>
                <button type="submit">Submit</button>
            </form>
            <div id="message"></div>
        </div>

        <div class="container" id="a2">
            <h1>Update Student Details</h1>
            <form id="updateForm">
                <div class="form-group">
                    <label for="updateStudentId">Student ID</label>
                    <input type="text" id="updateStudentId" name="updateStudentId" required>
                </div>
                <div class="form-group">
                    <label for="updateName">Name</label>
                    <input type="text" id="updateName" name="updateName" required>
                </div>
                <div class="form-group">
                    <label for="updateEmail">Email</label>
                    <input type="email" id="updateEmail" name="updateEmail" required>
                </div>
                <div class="form-group">
                    <label for="updateDob">Date of Birth</label>
                    <input type="date" id="updateDob" name="updateDob" required>
                </div>
                <div class="form-group">
                    <label for="updatePhone">Phone</label>
                    <input type="tel" id="updatePhone" name="updatePhone" required>
                </div>
                <div class="form-group">
                    <label for="updateCity">City</label>
                    <input type="text" id="updateCity" name="updateCity" required>
                </div>
                <div class="form-group">
                    <label for="updateDepartment">Department</label>
                    <input type="text" id="updateDepartment" name="updateDepartment" required>
                </div>
                <button type="submit">Update</button>
            </form>
            <div id="updateMessage"></div>
        </div>
    </div>


    <div id="b">
        <div class="container">
            <h1>Search Student by ID</h1>
            <form id="searchForm">
                <div class="form-group">
                    <label for="studentId">Student ID</label>
                    <input type="text" id="studentId" name="studentId" required>
                </div>
                <button type="submit">Search</button>
            </form>
            <div id="searchResult"></div>
        </div>

        <div class="container" id="b2">
            <h1>Delete Student by ID</h1>
            <form id="deleteForm">
                <div class="form-group">
                    <label for="deleteStudentId">Student ID</label>
                    <input type="text" id="deleteStudentId" name="deleteStudentId" required>
                </div>
                <button type="submit">Delete</button>
            </form>
            <div id="deleteMessage"></div>
        </div>

    </div>
</div>

<script src="update.js"></script>
<script src="script.js"></script>
<script src="delete.js"></script>
<script src="search.js"></script>
</body>
</html>
