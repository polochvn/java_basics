import jakarta.persistence.Column;

import java.io.Serializable;

public class PurchaseListPK implements Serializable {

    @Column(name = "student_name", nullable = false, insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name", nullable = false, insertable = false, updatable = false)
    private String courseName;

    public PurchaseListPK() {}

    public PurchaseListPK(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
