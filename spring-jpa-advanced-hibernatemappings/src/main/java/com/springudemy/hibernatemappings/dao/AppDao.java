package com.springudemy.hibernatemappings.dao;

import com.springudemy.hibernatemappings.entity.Course;
import com.springudemy.hibernatemappings.entity.Instructor;
import com.springudemy.hibernatemappings.entity.InstructorDetail;
import com.springudemy.hibernatemappings.entity.Student;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstrictorDetailById(int theId);

    void save(Course course1);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCourseByStudentId(int id);

    void update(Student student);

    void deleteCourseByCourseId(int id);

    void deleteStudentByStudentId(int id);
}
