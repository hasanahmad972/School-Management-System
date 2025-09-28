package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entity.Teacher;
import in.sp.main.service.TeacherService;

@RestController
public class MyController {
	@Autowired
	public TeacherService ts;
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
}

