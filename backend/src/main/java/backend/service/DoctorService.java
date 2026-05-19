package backend.service;

import backend.entity.Doctor;
import backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Save doctor
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Find by speciality
    public List<Doctor> getDoctorsBySpeciality(String speciality) {
        return doctorRepository.findBySpeciality(speciality);
    }

    public List<String> getAvailableTimeSlots(
        Long doctorId,
        String date
) {
    return List.of(
            "10:00 AM",
            "11:00 AM",
            "2:00 PM"
    );
}

public Map<String, Object> loginDoctor(
        String email,
        String password
) {

    Map<String, Object> response = new HashMap<>();

    Doctor doctor =
            doctorRepository.findByEmail(email);

    if(doctor != null &&
            doctor.getPassword().equals(password)) {

        response.put("message", "Login successful");
        response.put("doctor", doctor);

    } else {

        response.put("message", "Invalid credentials");
    }

    return response;
}

    // Login doctor
    public String loginDoctor(String email, String password) {

        Doctor doctor = doctorRepository.findByEmail(email);

        if (doctor != null && doctor.getPassword().equals(password)) {
            return "Login Successful";
        }

        return "Invalid Email or Password";
    }
}