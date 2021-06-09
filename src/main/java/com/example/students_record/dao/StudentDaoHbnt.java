package com.example.students_record.dao;
import java.util.List;

import com.example.students_record.model.Bed;
import com.example.students_record.model.Student;
import com.example.students_record.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDaoHbnt {


    /**
     * save Bed
     *
     * @param bed
     * */

    public Long saveBed(Bed bed){
        Transaction transaction = null;
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Long bedId = (Long) session.save(bed);
            transaction.commit();
            return bedId;
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
        return null;
    }

    /**
     * Save Student
     *
     * @param student
     */

    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(student);
            // commit transaction
            transaction.commit();
            System.out.println(" New student added using hibernate ok");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /**
     * Update Student
     *
     * @param student
     */
    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /**
     * Delete Student
     *
     * @param id
     */
    public void deleteStudent(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a student object
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                System.out.println("student is deleted");
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /**
     * Get Student By ID
     *
     * @param id
     * @return
     */
    public Student getStudent(int id) {
        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an student object
            student = session.get(Student.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;
    }
    /**
     * Get all Students
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Student> getAllStudents() {
        Transaction transaction = null;
        List<Student> listOfStudents = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an student object
            listOfStudents = session.createQuery("from Student").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfStudents;
    }
}
