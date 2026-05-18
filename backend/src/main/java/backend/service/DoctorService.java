package backend.service;

import backend.entity.Doctor;
import backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // Login doctor
    public String loginDoctor(String email, String password) {

        Doctor doctor = doctorRepository.findByEmail(email);

        if (doctor != null && doctor.getPassword().equals(password)) {
            return "Login Successful";
        }

        return "Invalid Email or Password";
    }
}