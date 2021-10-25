import javax.print.DocFlavor;

public class CourseDBElement{
    private String courseID;
    private int CRN;
    private int numberOfCredit;
    private String roomNumber;
    private String instructorName;

    //Default constructor
    public CourseDBElement(){

    }
    //2nd Constructor
    public CourseDBElement(String courseID, int CRN, int numberOfCredit, String roomNumber,String instructorName ){
        this.setCourseID(courseID);
        this.setCRN(CRN);
        this.setNumberOfCredit(numberOfCredit);
        this.setRoomNumber(roomNumber);
        this.setInstructorName(instructorName);
    }



    public int hashCode(){
        String CRNstring= String.valueOf(CRN);
        return CRNstring.hashCode();
    }
    // Make a toString
    @Override
    public String toString() {
        return "\nCourse:" +courseID +" CRN:" +CRN +" Credits:" +numberOfCredit +" Instructor:"
                +instructorName+ " Room:" +roomNumber;
    }

    //Getters & Setters
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getCRN() {
        return CRN;
    }

    public void setCRN(int CRN) {
        this.CRN = CRN;
    }

    public int getNumberOfCredit() {
        return numberOfCredit;
    }

    public void setNumberOfCredit(int numberOfCredit) {
        this.numberOfCredit = numberOfCredit;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}
