import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        Factory factory = new Factory();
        Session session = factory.openFactory().openSession();

        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = query.from(PurchaseList.class);
        query.select(root);

        List<PurchaseList> list = session.createQuery(query).getResultList();

        for (PurchaseList purchaseList : list) {

            String nameCourse = purchaseList.getCourseName();
            String nameStudent = purchaseList.getStudentName();

            String hqlStudent = "From " + Student.class.getSimpleName() +
                    " Where name = '" + nameStudent + "'";
            String hqlCourse = "From " + Course.class.getSimpleName() +
                    " Where name = '" + nameCourse + "'";

            List<Course> courses = session.createQuery(hqlCourse).getResultList();
            List<Student> students = session.createQuery(hqlStudent).getResultList();

            for (int i = 0; i < students.size(); i++) {
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                linkedPurchaseList.setId(new LinkedPurchaseListPK(
                        students.get(i).getId(), courses.get(i).getId()));
                session.saveOrUpdate(linkedPurchaseList);
            }
            }

        transaction.commit();
        session.close();
}

    public static Course getCourse(Session session, int id) {
        Course course = session.get(Course.class, id);
        return course;
    }
}
