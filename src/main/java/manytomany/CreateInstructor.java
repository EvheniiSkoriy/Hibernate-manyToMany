package manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructor {

    public static void main(String[] args) {

        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        try {


            session.beginTransaction();

            Course course = session.get(Course.class,3);

            Student student = new Student("Jon","Doe","jon@gmail.com");
            Student student1 = new Student("Ann","Bull","ann@gmail.com");
            Student student2 = new Student("Jack","Bolt","jack@gmail.com");

            course.addStudent(student);
            course.addStudent(student1);
            course.addStudent(student2);
            session.save(student);
            session.save(student1);
            session.save(student2);
            System.out.println(course);
            System.out.println("\nStudents on course: " + course.getStudentList()+"\n");

            session.getTransaction().commit();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();}
    }

}
