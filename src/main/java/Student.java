import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("studentFullName")
    private String fullName;
    @SerializedName("universityIdNumber")
    private String universityId;
    @SerializedName("courseNumber")
    private int currentCourseNumber;
    @SerializedName("averageExamScore")
    private float avgExamScore;
    @SerializedName("studyProfile")
    private StudyProfile studyProfile;

    public Student() {
    }

    public String getFullName() {
        return fullName;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUniversityId() {
        return universityId;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public Student setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                ", studyProfile=" + studyProfile +
                '}';
    }
}