package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) throws Exception {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) throw new Exception("Student with this email already exists");
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) throws Exception {
        boolean exists = studentRepository.existsById(id);
        if(!exists) throw new Exception("Student with " + id + " does not exists");
        studentRepository.deleteById(id);
    }

    @Transactional
    public void update(Long studentId, String name, String email) throws Exception {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new Exception("Student with id " + studentId + " does not exists")
        );
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) student.setName(name);
        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()) throw new Exception("Student with email: " + email + " already exists.");
        }
        student.setEmail(email);
    }
}
