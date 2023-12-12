package com.spring.orm.springorm.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.springorm.entity.Student;

public class StudentDaoImpl{

	private HibernateTemplate ht;
	
	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	//Saving into DB
	@Transactional
	public int insert(Student s) {
		// TODO Auto-generated method stub
		Integer save = (Integer)ht.save(s);
		return save;
	}
	
	//Getting a Single object
	public Student getStudent(int id) {
		Student student = this.ht.get(Student.class, id);
		return student;
	}
	
	//Getting All student
		public List<Student> getStudents() {
			List<Student> student = this.ht.loadAll(Student.class);
			return student;
		}
		
		@Transactional
		public void delete(int id) {
			Student student = this.ht.get(Student.class, id);
			this.ht.delete(student);
		}
		
		@Transactional
		public void update(Student s) {
			this.ht.update(s);
		}

}
