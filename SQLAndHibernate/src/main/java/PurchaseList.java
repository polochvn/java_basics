import jakarta.persistence.*;

@Entity
@Table(name = "PurchaseList")
public class PurchaseList {

    @EmbeddedId
    private PurchaseListPK purchaseListPK;

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    private int price;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PurchaseListPK getPurchaseListPK() {
        return purchaseListPK;
    }

    public void setPurchaseListPK(PurchaseListPK purchaseListPK) {
        this.purchaseListPK = purchaseListPK;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
