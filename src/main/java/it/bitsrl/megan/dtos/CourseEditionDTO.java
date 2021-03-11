package it.bitsrl.megan.dtos;

import it.bitsrl.megan.entities.Classroom;
import it.bitsrl.megan.entities.CourseEdition;
import it.bitsrl.megan.entities.RealClassroom;
import it.bitsrl.megan.entities.VirtualClassroom;
import java.time.LocalDateTime;

import java.util.Collection;

public class CourseEditionDTO {

    private long id;
    private LocalDateTime startDate;
    private String courseEditionName;
    private String classroomName;
    private int size;
    private int numModules;
    private String editionManager;
    private int duration;
    private double cost;
    private String program;
    private boolean certification;
    private String category;
    private String city;
    private long classroomId;
    private long courseId;
    private long employeeId;
    private String classroomType;


    public CourseEditionDTO(CourseEdition courseEdition){

        this.id = courseEdition.getId();
        this.startDate = courseEdition.getStartDate();
        this.courseEditionName = courseEdition.getCourseEditionName();
        this.classroomName = courseEdition.getClassroom().getName();
        this.size = courseEdition.getClassroom().getSize();
        this.numModules = courseEdition.getModules().size();
        this.editionManager = courseEdition.getEditionManager().getFirstName() + courseEdition.getEditionManager().getLastName();
        this.duration = courseEdition.getCourse().getDuration();
        this.cost = courseEdition.getCourse().getCost();
        this.program = courseEdition.getCourse().getProgram();
        this.certification = courseEdition.getCourse().isCertification();
        this.category = courseEdition.getCourse().getCategory();
        this.city = courseEdition.getCity();
        this.classroomId = courseEdition.getClassroom().getId();
        this.employeeId = courseEdition.getEditionManager().getId();
        this.courseId = courseEdition.getCourse().getId();
        this.classroomType = courseEdition.getClassroom() instanceof RealClassroom ? "real" : "virtual";

    }

    public CourseEditionDTO(String name, String category){
        this.courseEditionName = name;
        this.category = category;
    }
    public CourseEdition toCourseEdition(){
        Classroom classroom;
        if(this.classroomType.equals("real")){
             classroom = new RealClassroom(this.classroomId);
        }else{
             classroom = new VirtualClassroom(this.classroomId);
        }


       return null;
    }

    public long getId() {
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

    public String getCourseEditionName() {
        return courseEditionName;
    }

    public void setCourseEditionName(String courseEditionName) {
        this.courseEditionName = courseEditionName;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumModules() {
        return numModules;
    }

    public void setNumModules(int numModules) {
        this.numModules = numModules;
    }

    public String getEditionManager() {
        return editionManager;
    }

    public void setEditionManager(String editionManager) {
        this.editionManager = editionManager;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public boolean isCertification() {
        return certification;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
