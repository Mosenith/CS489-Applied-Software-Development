-- create tables
CREATE TABLE Dentist (
     dentistId VARCHAR(100) PRIMARY KEY,
     firstName VARCHAR(255),
     lastName VARCHAR(255),
     phone VARCHAR(100),
     email VARCHAR(255),
     specialized VARCHAR(255)
)

CREATE TABLE Patient (
     patientId VARCHAR(100) PRIMARY KEY,
     firstName VARCHAR(255),
     lastName VARCHAR(255),
     dob VARCHAR(100),
     phone VARCHAR(100),
     email VARCHAR(255),
     address VARCHAR(255)
);

CREATE TABLE Surgery (
     surgeryId VARCHAR(100) PRIMARY KEY,
     name VARCHAR(255),
     address VARCHAR(255),
);

CREATE TABLE Appointment (
     appointmentId VARCHAR(100) PRIMARY KEY,
     patientId VARCHAR(100),
     dentistId VARCHAR(100),
     date VARCHAR(100),
     time VARCHAR(100),
     FOREIGN KEY (patientId) REFERENCES Patient(patientId),
     FOREIGN KEY (dentistId) REFERENCES Dentist(dentistId)
);

-- Add Relationship between Appointment & Surgery
ALTER TABLE Appointment
ADD COLUMN surgeryId VARCHAR(100),
ADD FOREIGN KEY (surgeryId) REFERENCES Surgery(surgeryId);

-- Insert Dentist data
INSERT INTO Dentist (dentistId, firstName, lastName, phone, email, specialized)
VALUES
    ('DT1001', 'Tony', 'Smith', '123-456-7890', 'tony.smith@example.com', 'General Dentistry'),
    ('DT1002', 'Helen', 'Pearson', '234-567-8901', 'helen.pearson@example.com', 'Orthodontics'),
    ('DT1003', 'Robin', 'Plevin', '345-678-9012', 'robin.plevin@example.com', 'Oral Surgery');

-- Insert Patient data
INSERT INTO Patient (patientId, firstName, lastName, dob, phone, email, address)
VALUES
    ('P100', 'Gillian', 'White', '1990-05-15', '456-789-0123', 'gillian.white@example.com', '123 Main St'),
    ('P105', 'Jill', 'Bell', '1985-08-20', '567-890-1234', 'jill.bell@example.com', '456 Elm St'),
    ('P108', 'Ian', 'MacKay', '1978-03-10', '678-901-2345', 'ian.mackay@example.com', '789 Oak St'),
    ('P110', 'John', 'Walker', '1965-11-25', '789-012-3456', 'john.walker@example.com', '987 Pine St');

-- Insert Surgery data
INSERT INTO Surgery (surgeryId, appointmentId, name, address)
VALUES
    ('S15', 'A1001', 'Surgery Name 1', '123 Surgery St'),
    ('S15', 'A1002', 'Surgery Name 1', '123 Surgery St'),
    ('S15', 'A1003', 'Surgery Name 1', '123 Surgery St'),
    ('S10', 'A1004', 'Surgery Name 2', '456 Operation Ave'),
    ('S10', 'A1005', 'Surgery Name 2', '456 Operation Ave'),
    ('S13', 'A1006', 'Surgery Name 3', '789 Medical Blvd');

-- Insert Appointment data
INSERT INTO Appointment (appointmentId, patientId, dentistId, date, time, surgeryId)
VALUES
    ('A1001', 'P100', 'DT1001', '2013-09-12', '10:00', 'S15'),
    ('A1002', 'P105', 'DT1001', '2013-09-12', '12:00', 'S15'),
    ('A1003', 'P105', 'DT1003', '2013-09-14', '16:30', 'S15'),
    ('A1004', 'P108', 'DT1002', '2013-09-12', '10:00', 'S10'),
    ('A1005', 'P108', 'DT1002', '2013-09-14', '14:00', 'S10'),
    ('A1006', 'P110', 'DT1003', '2013-09-15', '18:00', 'S13');

