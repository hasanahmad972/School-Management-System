package in.sp.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entity.Teacher;



public interface TeacherRepository extends  JpaRepository<Teacher,Integer>{
     Teacher findByEmail(String email);
}
