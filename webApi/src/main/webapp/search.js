document.getElementById("searchForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const studentId = document.getElementById("studentId").value;

    try {
        const response = await fetch(`http://localhost:8080/api/stud/${studentId}`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        });

        const data = await response.json();
        console.log('Response Status:', response.status);
        console.log('Response Data:', data);

        if (response.ok) {
            displaySearchResult(data);
        } else {
            document.getElementById("searchResult").textContent = data.message || "An error occurred during the search.";
        }
    } catch (error) {
        console.error("Error:", error);
        document.getElementById("searchResult").textContent = "An error occurred during the search.";
    }
});

function displaySearchResult(student) {
    const searchResultDiv = document.getElementById("searchResult");
    searchResultDiv.innerHTML = `
        <h2>Student Details</h2>
        <p><strong>ID:</strong> ${student.id}</p>
        <p><strong>Name:</strong> ${student.name}</p>
        <p><strong>Email:</strong> ${student.email}</p>
        <p><strong>Date of Birth:</strong> ${student.dob}</p>
        <p><strong>Phone:</strong> ${student.phone}</p>
        <p><strong>City:</strong> ${student.city}</p>
        <p><strong>Department:</strong> ${student.department}</p>
    `;
}
