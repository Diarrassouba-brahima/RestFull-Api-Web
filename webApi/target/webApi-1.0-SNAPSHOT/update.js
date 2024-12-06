document.getElementById("updateForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const studentId = document.getElementById("updateStudentId").value;
    const name = document.getElementById("updateName").value;
    const email = document.getElementById("updateEmail").value;
    const dob = document.getElementById("updateDob").value;
    const phone = document.getElementById("updatePhone").value;
    const city = document.getElementById("updateCity").value;
    const department = document.getElementById("updateDepartment").value;

    try {
        const response = await fetch(`http://localhost:8080/api/stud/${studentId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: name,
                email: email,
                dob: dob,
                phone: phone,
                city: city,
                department: department
            })
        });

        if (response.ok) {
            document.getElementById("updateMessage").textContent = "Update successful!";
        } else {
            const data = await response.json();
            document.getElementById("updateMessage").textContent = data.message || "An error occurred during the update.";
        }
    } catch (error) {
        console.error("Error:", error);
        document.getElementById("updateMessage").textContent = "An error occurred during the update.";
    }
});
