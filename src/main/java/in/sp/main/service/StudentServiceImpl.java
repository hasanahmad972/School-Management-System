package in.sp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entity.Student;
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
 
}
