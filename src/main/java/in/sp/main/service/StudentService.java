package in.sp.main.service;

import in.sp.main.entity.Student;
import in.sp.main.entity.Teacher;

public interface StudentService {

	Student AddStudent(Student s);

   Student GetStudent(String email, String password);
 
}
