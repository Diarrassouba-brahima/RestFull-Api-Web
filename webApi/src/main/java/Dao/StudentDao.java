package Dao;


import entity.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class StudentDao {
    @PersistenceContext(unitName = "my_persistence")
    EntityManager em;

    public List<Student> getALLUsers(){

        return em.createNamedQuery("student.getALL", Student.class).getResultList();
    }
    public Student getUser(int id){
        return em.find(Student.class, id);
    }

    public void update(Student student) {
        em.merge(student);
    }

    public void create(Student student) {
        em.persist(student);
    }

    public void delete(Student student) {
        if (!em.contains(student)) {
            student = em.merge(student);
        }

        em.remove(student);
    }

}
