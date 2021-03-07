package it.bitsrl.megan.entities;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="course_edition")
public class CourseEdition {

   @Id
   @GeneratedValue
   private long id;

   private LocalDateTime startDate;

   @ManyToOne
   private Classroom classroom;

   @OneToMany(mappedBy="edition")
   private Collection<Application> applicatedStudents;

   @OneToMany(mappedBy="courseEdition")
   private Collection<Enrollment> enrolledStudents;// elenco partecipanti

   @OneToMany(mappedBy="edition")
   private Collection<Module> modules;

   @ManyToOne
   private Employee editionManager;

   @ManyToOne
   private Course course;

   private String courseEditionName;

   public CourseEdition(long id, String name){
      this.courseEditionName = name;
      this.id = id;
   }

}
