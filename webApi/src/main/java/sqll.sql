CREATE TABLE student (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100),
                         email VARCHAR(100),
                         dob DATE,
                         phone VARCHAR(20),
                         city VARCHAR(50),
                         department VARCHAR(50)
);


INSERT INTO student (name, email, dob, phone, city, department) VALUES
                                                                    ('Alice Johnson', 'alice.johnson@example.com', '2000-04-15', '555-1234', 'New York', 'Computer Science'),
                                                                    ('Bob Smith', 'bob.smith@example.com', '1999-08-22', '555-5678', 'Los Angeles', 'Mathematics'),
                                                                    ('Carol White', 'carol.white@example.com', '2001-01-30', '555-8765', 'Chicago', 'Physics'),
                                                                    ('David Brown', 'david.brown@example.com', '1998-11-12', '555-4321', 'Houston', 'Chemistry'),
                                                                    ('Eve Davis', 'eve.davis@example.com', '2002-05-09', '555-6789', 'Philadelphia', 'Biology');
