package in.sp.main.service;

import java.util.Optional;

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

	@Override
	public Student updateStudentEmail(int id, String email) {
		      Student validStudent=sr.getById(id);
		if(validStudent!=null) {
			
			validStudent.setEmail(email);
			return sr.save(validStudent);
		}
			else {
			throw new RuntimeException("Invalid Id ");}
		
	}

	@Override
	public Student updateStudentName(int id, String name) {
	      Student validStudent=sr.getById(id);
			if(validStudent!=null) {
				
				validStudent.setName(name);
				return sr.save(validStudent);
			}
				else {
				throw new RuntimeException("Invalid Id ");}
	}

	@Override
	public Student updateStudentCourse(int id, String course) {
	      Student validStudent=sr.getById(id);
			if(validStudent!=null) {
				
				validStudent.setCourse(course);
				return sr.save(validStudent);
			}
				else {
				throw new RuntimeException("Invalid Id ");}
	}
 
}
