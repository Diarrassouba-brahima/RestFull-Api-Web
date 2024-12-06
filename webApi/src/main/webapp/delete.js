document.getElementById("deleteForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const studentId = document.getElementById("deleteStudentId").value;

    try {
        const response = await fetch(`http://localhost:8080/api/stud/${studentId}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }
        });

        if (response.ok) {
            document.getElementById("deleteMessage").textContent = "Deletion successful!";
        } else {
            const data = await response.json();
            document.getElementById("deleteMessage").textContent = data.message || "An error occurred during deletion.";
        }
    } catch (error) {
        console.error("Error:", error);
        document.getElementById("deleteMessage").textContent = "An error occurred during deletion.";
    }
});
