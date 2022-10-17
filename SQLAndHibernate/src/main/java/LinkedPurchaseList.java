import jakarta.persistence.*;

@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListPK id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private Integer studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer courseId;

    @ManyToOne(targetEntity = Course.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne(targetEntity = Course.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LinkedPurchaseListPK getId() {
        return id;
    }

    public void setId(LinkedPurchaseListPK id) {
        this.id = id;
    }
}
