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
	   
	   
}
