package Edusmart_project;

public class EduSmartLMS {

	public static void main(String[] args) {
		// Interface
		interface ProgressTrackable {
		    void trackProgress();
		}

		// Abstract class User
		abstract class User {
		    private String name;
		    private String email;
		    private String userId;

		    public User(String name, String email, String userId) {
		        this.name = name;
		        this.email = email;
		        this.userId = userId;
		    }

		    public String getName() {
		        return name;
		    }

		    public String getEmail() {
		        return email;
		    }

		    public String getUserId() {
		        return userId;
		    }

		    public void setName(String name) {
		        this.name = name;
		    }

		    public void setEmail(String email) {
		        this.email = email;
		    }

		    public void setUserId(String userId) {
		        this.userId = userId;
		    }

		    public final void displayWelcome() {
		        System.out.println("Welcome to EduSmart LMS");
		    }

		    abstract void viewProfile();
		}

		// Student class
		class Student extends User implements ProgressTrackable {
		    private String enrolledCourse1;
		    private String enrolledCourse2;

		    public Student(String name, String email, String userId) {
		        super(name, email, userId);
		        this.enrolledCourse1 = null;
		        this.enrolledCourse2 = null;
		    }

		    public void enrollCourse(String courseName) {
		        if (this.enrolledCourse1 == null) {
		            this.enrolledCourse1 = courseName;
		        } else if (this.enrolledCourse2 == null) {
		            this.enrolledCourse2 = courseName;
		        } else {
		            System.out.println("Cannot enroll in more than 2 courses.");
		        }
		    }

		    @Override
		    public void viewProfile() {
		        System.out.println("Student Profile: " + getName() + ", " + getEmail());
		    }

		    @Override
		    public void trackProgress() {
		        System.out.println(getName() + " is tracking progress in " + enrolledCourse1 + ", " + enrolledCourse2);
		    }
		}

		// Instructor class
		class Instructor extends User {
		    private String createdCourse1;
		    private String createdCourse2;

		    public Instructor(String name, String email, String userId) {
		        super(name, email, userId);
		    }

		    public void createCourse(String courseName) {
		        if (createdCourse1 == null) {
		            createdCourse1 = courseName;
		        } else if (createdCourse2 == null) {
		            createdCourse2 = courseName;
		        } else {
		            System.out.println("Instructor can't create more than 2 courses.");
		        }
		    }

		    @Override
		    public void viewProfile() {
		        System.out.println("Instructor Profile: " + getName() + ", " + getEmail());
		    }
		}

		// Admin class
		class Admin extends User {
		    public Admin(String name, String email, String userId) {
		        super(name, email, userId);
		    }

		    public void removeUser(User user) {
		        System.out.println("Removed user: " + user.getName());
		    }

		    @Override
		    public void viewProfile() {
		        System.out.println("Admin Profile: " + getName() + ", " + getEmail());
		    }
		}

		// Course class
		class Course {
		    private String title;
		    private int durationInHours;
		    private final int maxStudents;

		    public Course(String title, int durationInHours, int maxStudents) {
		        this.title = title;
		        this.durationInHours = durationInHours;
		        this.maxStudents = maxStudents;
		    }

		    public Course(String title) {
		        this.title = title;
		        this.durationInHours = 0;
		        this.maxStudents = 0;
		    }

		    public void showCourseDetails() {
		        System.out.println("Course: " + title + ", Duration: " + durationInHours + " hrs, Max Students: " + maxStudents);
		    }
		}

		// Main Class
		public class EduSmartLMS {
		    public static void main(String[] args) {
		        // Create users
		        Student s1 = new Student("Ram", "ram@example.com", "S001");
		        Student s2 = new Student("Seetha", "seetha@example.com", "S002");

		        Instructor i1 = new Instructor("Mr. Ravi", "ravi@edu.com", "I001");
		        Instructor i2 = new Instructor("Ms. Devi", "devi@edu.com", "I002");

		        Admin admin = new Admin("Admin1", "admin@edu.com", "A001");

		        // Instructors create courses
		        i1.createCourse("Java Basics");
		        i1.createCourse("OOP Concepts");
		        i2.createCourse("Data Structures");
		        i2.createCourse("Algorithms");

		        // Students enroll in courses
		        s1.enrollCourse("Java Basics");
		        s1.enrollCourse("Data Structures");
		        s2.enrollCourse("OOP Concepts");
		        s2.enrollCourse("Algorithms");

		        // Display profiles
		        s1.viewProfile();
		        s2.viewProfile();
		        i1.viewProfile();
		        i2.viewProfile();
		        admin.viewProfile();

		        // Track progress
		        s1.trackProgress();
		        s2.trackProgress();

		        // Remove user
		        admin.removeUser(s1);

		        // Show course details
		        Course c1 = new Course("Java Basics", 40, 30);
		        Course c2 = new Course("Data Structures");

		        c1.showCourseDetails();
		        c2.showCourseDetails();
		    }
		}

	}

}
