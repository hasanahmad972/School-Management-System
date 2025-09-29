package in.sp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entity.Teacher;
import in.sp.main.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements  TeacherService{
	   @Autowired
       public TeacherRepository tr;
	   
	   @Override
	   public Teacher AddTeacher(Teacher t) {
		 
		 return tr.save(t);
		 
		   
		  
	   }

	   @Override
	   public Teacher GetTeacher(String email, String password) {
		 Teacher validTeacher=tr.findByEmail(email);
		 if(validTeacher!=null&&validTeacher.getPassword().equals(password)) {
			 return validTeacher;
		 }
		 else {
			 throw new RuntimeException("Invalid Username or Password ");
		 }
	   }

	 
	   
	
	   
	   
}
