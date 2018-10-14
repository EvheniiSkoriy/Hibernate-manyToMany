package manytomany;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    //annotate the class as an entity and add to db table

    //define the fields

    //annotate the fields with db column names

    //create constructors

    //generate toString method

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList;

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Instructor() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void addCourse(Course course){
        if(courseList ==null){
            courseList =new ArrayList<Course>();
        }
        courseList.add(course);

        course.setInstructor(this);
    }

    @Override
    public String toString() {
        return "Instructor " +
                "id: " + id +
                ", firstName: " + firstName + '\'' +
                ", lastName: " + lastName + '\'' +
                ", email: " + email+ "\n"+ courseList;
    }
}
