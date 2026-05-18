package backend.controller;

import backend.entity.Doctor;
import backend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Add doctor
    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    // Get all doctors
    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Search by speciality
    @GetMapping("/speciality/{speciality}")
    public List<Doctor> getDoctorsBySpeciality(@PathVariable String speciality) {
        return doctorService.getDoctorsBySpeciality(speciality);
    }

    // Login
    @PostMapping("/login")
    public String loginDoctor(@RequestParam String email,
                              @RequestParam String password) {

        return doctorService.loginDoctor(email, password);
    }
}