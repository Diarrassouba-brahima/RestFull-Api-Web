document.getElementById("registrationForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const dob = document.getElementById("dob").value;
    const phone = document.getElementById("phone").value;
    const city = document.getElementById("city").value;
    const department = document.getElementById("department").value;

    try {
        const response = await fetch(`http://localhost:8080/api/stud`, {
            method: "POST",
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
            // Check if the status code is 201 (Created)
            if (response.status === 201) {
                document.getElementById("message").textContent = "Registration successful!";
            } else {
                const data = await response.json();
                document.getElementById("message").textContent = data.message || "Registration successful with an unexpected status code.";
            }
        } else {
            const data = await response.json();
            document.getElementById("message").textContent = data.message || "An error occurred during registration.";
        }
    } catch (error) {
        console.error("Error:", error);
        document.getElementById("message").textContent = "An error occurred during registration.";
    }
});



