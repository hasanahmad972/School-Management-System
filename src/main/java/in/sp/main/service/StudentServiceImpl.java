package in.sp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entity.Student;
import in.sp.main.entity.Teacher;
import in.sp.main.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
    public StudentRepository sr;
	
	@Override
	public Student AddStudent(Student s) {
		Student ss=sr.save(s);
		return ss;
	}

	@Override
	public Student GetStudent(String email, String password) {
		Student validStudent=sr.findByEmail(email);
		if(validStudent!=null&&validStudent.getPassword().equals(password)) {
		return validStudent;}
		else {
		throw new RuntimeException("Invalid Username or Password ");}
	}
 
}
