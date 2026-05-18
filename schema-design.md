# Smart Clinic Management System Database Schema

## Doctor Table

| Field Name      | Data Type      | Constraints |
|-----------------|---------------|-------------|
| id              | BIGINT        | PRIMARY KEY, AUTO_INCREMENT |
| name            | VARCHAR(255)  | NOT NULL |
| speciality      | VARCHAR(255)  | NOT NULL |
| available_times | VARCHAR(255)  | NULL |
| email           | VARCHAR(255)  | UNIQUE |
| password        | VARCHAR(255)  | NOT NULL |

---

## Patient Table

| Field Name   | Data Type      | Constraints |
|--------------|---------------|-------------|
| id           | BIGINT        | PRIMARY KEY, AUTO_INCREMENT |
| name         | VARCHAR(255)  | NOT NULL |
| email        | VARCHAR(255)  | UNIQUE |
| phone_number | VARCHAR(20)   | NULL |
| password     | VARCHAR(255)  | NOT NULL |

---

## Appointment Table

| Field Name       | Data Type      | Constraints |
|------------------|---------------|-------------|
| id               | BIGINT        | PRIMARY KEY, AUTO_INCREMENT |
| doctor_id        | BIGINT        | FOREIGN KEY |
| patient_id       | BIGINT        | FOREIGN KEY |
| appointment_time | DATETIME      | NOT NULL |
| status           | VARCHAR(50)   | NULL |

---

## Prescription Table

| Field Name      | Data Type      | Constraints |
|----------------|---------------|-------------|
| id             | BIGINT        | PRIMARY KEY, AUTO_INCREMENT |
| appointment_id | BIGINT        | FOREIGN KEY |
| medicine       | TEXT          | NOT NULL |
| notes          | TEXT          | NULL |

---

# Relationships

- Appointment.doctor_id → Doctor.id
- Appointment.patient_id → Patient.id
- Prescription.appointment_id → Appointment.id