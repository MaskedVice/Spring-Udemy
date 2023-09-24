package com.springudemy.hibernatemappings.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springudemy.hibernatemappings.entity.Course;
import com.springudemy.hibernatemappings.entity.Instructor;
import com.springudemy.hibernatemappings.entity.InstructorDetail;
import com.springudemy.hibernatemappings.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDapImpl implements AppDao {

    private EntityManager em;

    @Autowired
    public AppDapImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        em.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return em.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor theInstructor = em.find(Instructor.class, theId);
        em.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return em.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstrictorDetailById(int theId) {
        InstructorDetail theInstructorDetail = em.find(InstructorDetail.class, theId);
        em.remove(theInstructorDetail);
        
    }

    @Override
    @Transactional
    public void save(Course course1) {
        em.persist(course1);
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {
        
        TypedQuery<Course> query = em.createQuery(
                    "select c from Course c "+
                    "JOIN FETCH c.students " +
                    "where c.id = :data", Course.class);
        query.setParameter("data", id);
        Course course = query.getSingleResult();
        
        return course;

    }

    @Override
    public Student findStudentAndCourseByStudentId(int id) {
        TypedQuery<Student> query = em.createQuery(
                "select s from Student s "+
                "JOIN FETCH s.courses " +
                "where s.id = :data", Student.class);
        query.setParameter("data", id);
        Student student = query.getSingleResult();
        return student;
    }

    @Override
    @Transactional
    public void update(Student student) {
        em.merge(student);
    }

    @Override
    @Transactional
    public void deleteCourseByCourseId(int id) {
        em.remove(em.find(Course.class, id));
    }

    @Override
    @Transactional
    public void deleteStudentByStudentId(int id) {
            Student student = em.find(Student.class, id);
            em.remove(student);
    }
    
}
