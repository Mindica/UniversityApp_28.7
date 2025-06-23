public class Statistics {
    private String profile;
    private Double averageGrade;
    private int studentsCount;
    private int universitiesCount;
    private String universityName;

    public Statistics(String profile, Double averageGrade, int studentsCount, int universitiesCount, String universityName) {
        this.profile = profile;
        this.averageGrade = averageGrade;
        this.studentsCount = studentsCount;
        this.universitiesCount = universitiesCount;
        this.universityName = universityName;
    }

    public String getProfile() {
        return profile;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public int getUniversitiesCount() {
        return universitiesCount;
    }

    public String getUniversityName() {
        return universityName;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "profile='" + profile + '\'' +
                ", averageGrade=" + averageGrade +
                ", studentsCount=" + studentsCount +
                ", universitiesCount=" + universitiesCount +
                ", universityName='" + universityName + '\'' +
                '}';
    }
}