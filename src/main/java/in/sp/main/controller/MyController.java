package in.sp.main.controller;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entity.Student;
import in.sp.main.entity.Teacher;
import in.sp.main.service.StudentService;
import in.sp.main.service.TeacherService;

@RestController
public class MyController {
	@Autowired
	public TeacherService ts;
	@Autowired
	public StudentService ss;
	
	@PostMapping("/teacher")
  public ResponseEntity<?> addteacher(@RequestBody Teacher t) {
	    try {
	    	Teacher te=ts.AddTeacher(t);
	    	System.out.println(te);
	    	return ResponseEntity.ok("Teacher added Succesfully");
	    }
	    catch(Exception e) {
	    	return ResponseEntity
	    			.badRequest()
	    			.body("Teacher saved failed :"+e.getMessage());
	    }
	    
	  
  }
	
	@PostMapping("/teacher/login")
    public ResponseEntity<?> loginteacher(@RequestBody Teacher t,HttpSession session){
		       System.out.println(t);
		try {
			Teacher validTeacher=ts.GetTeacher(t.getEmail(), t.getPassword());
			if(validTeacher!=null) {
				session.setAttribute("username",validTeacher.getFullname());
			}
			return ResponseEntity.ok(validTeacher.getFullname()+" login succesfully");
		}
		catch(Exception e) {
			return ResponseEntity
					.badRequest()
					.body("error :"+e.getMessage());
		}
		
		  
    	
    }
	@GetMapping("/teacher/login/user-info")
	public Map<String,String> userInfo(HttpSession session){
		Map<String,String> response=new HashMap();
		String username=(String)session.getAttribute("username");
		if(username!=null) {
			response.put("username", username);
			
		}
		else {
			response.put("error","not logged in" );
		}
		return response;
	}
	@PostMapping("/student/adddetails")
	  public ResponseEntity<?> addStudent(@RequestBody Student s) {
		    try {
		        Student savedStudent = ss.AddStudent(s);  // service layer call
		        return ResponseEntity.ok(savedStudent);
		    } catch (Exception e) {
		        Map<String, String> errorResponse = new HashMap<>();
		        errorResponse.put("error", "Student save failed: " + e.getMessage());
		        return ResponseEntity
		                .badRequest()
		                .body(errorResponse);
		    }
		}
	@PostMapping("/student/login")
    public ResponseEntity<?> loginstudent(@RequestBody Student s,HttpSession session){
		       System.out.println(s);
		try {
			Student validStudent=ss.GetStudent(s.getEmail(), s.getPassword());
			if(validStudent!=null) {
				session.setAttribute("username",validStudent.getName());
			}
			return ResponseEntity.ok(validStudent.getName()+" login succesfully");
		}
		catch(Exception e) {
			return ResponseEntity
					.badRequest()
					.body("error :"+e.getMessage());
		}
		
		  
    	
    }
	
}


