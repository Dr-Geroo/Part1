import java.util.ArrayList;
import java.util.List;

// Class representing a Course
class Course {
    private String courseName;
    private Lecturer assignedLecturer;
    private List<Student> enrolledStudents;

    // Constructor for Course
    public Course(String courseName, Lecturer assignedLecturer) {
        this.courseName = courseName;
        this.assignedLecturer = assignedLecturer;
        this.enrolledStudents = new ArrayList<>();
    }

    // Method to enroll a student in a course
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    // Getter method for enrolled students in the course
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Getter method for assigned lecturer of the course
    public Lecturer getAssignedLecturer() {
        return assignedLecturer;
    }

    // Setter method for assigned lecturer of the course
    public void setAssignedLecturer(Lecturer assignedLecturer) {
        this.assignedLecturer = assignedLecturer;
    }

    // Getter method for course name
    public String getCourseName() {
        return courseName;
    }
}

// Class representing an Admin
class Admin {
    private List<Student> students;
    private List<Lecturer> lecturers;
    private List<Course> courses;

    // Constructor for Admin
    public Admin() {
        this.students = new ArrayList<>();
        this.lecturers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    // Method to create a new student and add it to the list of students
    public void createStudent(String username, String password) {
        Student student = new Student(username, password);
        students.add(student);
    }

    // Method to create a new lecturer and add it to the list of lecturers
    public void createLecturer(String username, String password) {
        Lecturer lecturer = new Lecturer(username, password);
        lecturers.add(lecturer);
    }

    // Method to create a new course and add it to the list of courses
    public void createCourse(String courseName, Lecturer lecturer) {
        Course course = new Course(courseName, lecturer);
        courses.add(course);
    }

    // Method to assign a course to a lecturer
    public void assignCourseToLecturer(Course course, Lecturer lecturer) {
        course.setAssignedLecturer(lecturer);
    }

    // Getter method for list of students
    public List<Student> getStudents() {
        return students;
    }

    // Getter method for list of lecturers
    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    // Getter method for list of courses
    public List<Course> getCourses() {
        return courses;
    }

    // Method to view students enrolled in a course for a specific lecturer
    public void viewStudentsInCourse(Lecturer lecturer, Course course) {
        List<Student> students = course.getEnrolledStudents();
        System.out.println("Students enrolled in " + course.getCourseName() + " for " + lecturer.getUsername() + ":");
        for (Student student : students) {
            System.out.println("- " + student.getUsername());
        }
    }

    // Method to view all students and lecturers
    public void viewAllStudentsAndLecturers() {
        System.out.println("\nAll Students:");
        for (Student student : students) {
            System.out.println("- " + student.getUsername());
        }

        System.out.println("\nAll Lecturers:");
        for (Lecturer lecturer : lecturers) {
            System.out.println("- " + lecturer.getUsername());
        }
    }
}

// Class representing a User
class User {
    private String username;
    private String password;

    // Constructor for User
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter method for username
    public String getUsername() {
        return username;
    }

    // Getter method for password
    public String getPassword() {
        return password;
    }
}

// Class representing a Student, extending User
class Student extends User {
    // Constructor for Student
    public Student(String username, String password) {
        super(username, password);
    }

    // Method for a student to register for a course
    public void registerForCourse(Course course) {
        course.enrollStudent(this);
    }
}

// Class representing a Lecturer, extending User
class Lecturer extends User {
    // Constructor for Lecturer
    public Lecturer(String username, String password) {
        super(username, password);
    }
}

// Main class
public class Part1 {
    public static void main(String[] args) {
        // Creating an instance of Admin
        Admin admin = new Admin();

        // Creating students
        admin.createStudent("student1", "pass123");
        admin.createStudent("student2", "pass456");
        admin.createStudent("student3", "pass789");

        // Creating lecturers
        admin.createLecturer("lecturer1", "pass111");
        admin.createLecturer("lecturer2", "pass222");

        // Getting references to the created lecturers
        Lecturer lecturer1 = admin.getLecturers().get(0);
        Lecturer lecturer2 = admin.getLecturers().get(1);

        // Creating courses and associating them with respective lecturers
        admin.createCourse("Java Programming", lecturer1);
        admin.createCourse("Data Structures", lecturer2);

        // Getting references to the created courses
        Course course1 = admin.getCourses().get(0);
        Course course2 = admin.getCourses().get(1);

        // Getting references to the created students
        Student student1 = admin.getStudents().get(0);
        Student student2 = admin.getStudents().get(1);
        Student student3 = admin.getStudents().get(2);

        // Registering students for courses
        student1.registerForCourse(course1);
        student1.registerForCourse(course2);
        student2.registerForCourse(course1);
        student3.registerForCourse(course2);

        // Viewing students enrolled in courses for specific lecturers
        admin.viewStudentsInCourse(lecturer1, course1);
        admin.viewStudentsInCourse(lecturer2, course2);

        // Viewing all students and lecturers
        admin.viewAllStudentsAndLecturers();
    }
}

