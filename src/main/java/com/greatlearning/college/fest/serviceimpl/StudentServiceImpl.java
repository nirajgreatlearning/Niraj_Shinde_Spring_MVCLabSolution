package com.greatlearning.college.fest.serviceimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.college.fest.models.Student;
import com.greatlearning.college.fest.service.StudentService;

@Repository
public class StudentServiceImpl implements StudentService {
	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException exc) {
			this.session = this.sessionFactory.openSession();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		return this.session.createQuery("from Student").list();
	}

	@Override
	public Student getStudentById(long studentId) {
		return this.session.get(Student.class, studentId);
	}

	@Override
	public void saveStudent(Student student) {
		Transaction tx = this.session.beginTransaction();
		if (student.getId() > 0) {
			this.session.merge(student);
		} else {
			this.session.save(student);
		}
		tx.commit();
	}

	@Override
	public void deleteStudent(long studentId) {
		Transaction tx = this.session.beginTransaction();
		this.session.delete(this.session.get(Student.class, studentId));
		tx.commit();
	}
}
