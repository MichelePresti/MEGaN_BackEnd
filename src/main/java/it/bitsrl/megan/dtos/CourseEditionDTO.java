package it.bitsrl.megan.dtos;

import it.bitsrl.megan.entities.CourseEdition;

import java.util.Collection;
import java.util.stream.Collectors;

public class CourseEditionDTO {

    private long id;
    private String startDate;
    private ClassroomDTO classroom;
    private Collection<ApplicationDTO> applicatedStudents;
    private Collection<EnrollmentDTO> enrolledStudents;
    private Collection<ModuleDTO> modules;
    private PersonDTO editionManager;
    private CourseDTO course;
    private String city;
    private String courseEditionName;
    private int duration;

    public CourseEditionDTO(){}

    public CourseEditionDTO(CourseEdition ce){
        this.id = ce.getId();
        this.startDate = ce.getStartDate().toString();
        this.classroom = new ClassroomDTO(ce.getClassroom());
        this.applicatedStudents = ce.getApplicatedStudents().stream().map(ApplicationDTO::new).collect(Collectors.toList());
        this.enrolledStudents = ce.getEnrolledStudents().stream().map(EnrollmentDTO::new).collect(Collectors.toList());
        this.modules = ce.getModules().stream().map(ModuleDTO::new).collect(Collectors.toList());
        this.editionManager = new PersonDTO(ce.getEditionManager());
        this.course = new CourseDTO(ce.getCourse());
        this.city = ce.getCity();
        this.courseEditionName = ce.getCourseEditionName();
        this.duration = ce.getDuration();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public ClassroomDTO getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassroomDTO classroom) {
        this.classroom = classroom;
    }

    public Collection<ApplicationDTO> getApplicatedStudents() {
        return applicatedStudents;
    }

    public void setApplicatedStudents(Collection<ApplicationDTO> applicatedStudents) {
        this.applicatedStudents = applicatedStudents;
    }

    public Collection<EnrollmentDTO> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Collection<EnrollmentDTO> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Collection<ModuleDTO> getModules() {
        return modules;
    }

    public void setModules(Collection<ModuleDTO> modules) {
        this.modules = modules;
    }

    public PersonDTO getEditionManager() {
        return editionManager;
    }

    public void setEditionManager(PersonDTO editionManager) {
        this.editionManager = editionManager;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCourseEditionName() {
        return courseEditionName;
    }

    public void setCourseEditionName(String courseEditionName) {
        this.courseEditionName = courseEditionName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
