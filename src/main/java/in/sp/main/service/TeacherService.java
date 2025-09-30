package in.sp.main.service;

import in.sp.main.entity.Student;
import in.sp.main.entity.Teacher;

public interface TeacherService {
	public Teacher AddTeacher(Teacher t);
	public Teacher GetTeacher(String email,String password);
	
	   
}
