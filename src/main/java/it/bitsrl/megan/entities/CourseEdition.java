package it.bitsrl.megan.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="course_edition")
public class CourseEdition {


   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;

   private LocalDateTime startDate;

   @ManyToOne
   private Classroom classroom;

   @OneToMany(mappedBy="edition")
   private Collection<Application> applicatedStudents;

   @OneToMany(mappedBy="courseEdition")
   private Collection<Enrollment> enrolledStudents;// elenco partecipanti

   @OneToMany(mappedBy="edition",
   cascade={CascadeType.ALL})
   private Collection<Module> modules;

   @ManyToOne
   private Employee editionManager;

   @ManyToOne
   private Course course;

   private String city;

   private String courseEditionName;

   private int duration;

   public CourseEdition(){}

   public CourseEdition(long id, String name){
      this.courseEditionName = name;
      this.id = id;
   }

   public CourseEdition(Long id, LocalDateTime startDate, Classroom classroom, Collection<Application> applicatedStudents, Collection<Enrollment> enrolledStudents, Collection<Module> modules, Employee editionManager, Course course, String city, String courseEditionName, int duration) {
      this.id = id;
      this.startDate = startDate;
      this.classroom = classroom;
      this.applicatedStudents = applicatedStudents;
      this.enrolledStudents = enrolledStudents;
      this.modules = modules;
      this.editionManager = editionManager;
      this.course = course;
      this.city = city;
      this.courseEditionName = courseEditionName;
      this.duration = duration;
   }

   public Long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public LocalDateTime getStartDate() {
      return startDate;
   }

   public void setStartDate(LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public Classroom getClassroom() {
      return classroom;
   }

   public void setClassroom(Classroom classroom) {
      this.classroom = classroom;
   }

   public Collection<Application> getApplicatedStudents() {
      return applicatedStudents;
   }

   public void setApplicatedStudents(Collection<Application> applicatedStudents) {
      this.applicatedStudents = applicatedStudents;
   }

   public Collection<Enrollment> getEnrolledStudents() {
      return enrolledStudents;
   }

   public void setEnrolledStudents(Collection<Enrollment> enrolledStudents) {
      this.enrolledStudents = enrolledStudents;
   }

   public Collection<Module> getModules() {
      return modules;
   }

   public void setModules(Collection<Module> modules) {
      this.modules = modules;
   }

   public Employee getEditionManager() {
      return editionManager;
   }

   public void setEditionManager(Employee editionManager) {
      this.editionManager = editionManager;
   }

   public Course getCourse() {
      return course;
   }

   public void setCourse(Course course) {
      this.course = course;
   }

   public String getCourseEditionName() {
      return courseEditionName;
   }

   public void setCourseEditionName(String courseEditionName) {
      this.courseEditionName = courseEditionName;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public int getDuration() {
      return duration;
   }

   public void setDuration(int duration) {
      this.duration = duration;
   }
}
