public class ComparatorUtil {

    private ComparatorUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static StudentComparator getStudentComparator(StudentComparatorType type) {
        switch (type) {
            case FULL_NAME:
                return new StudentFullNameComparator();
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case CURRENT_COURSE_NUMBER:
                return new StudentCurrentCourseNumberComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            default:
                throw new IllegalArgumentException("Invalid StudentComparatorType: " + type);
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType type) {
        switch (type) {
            case ID:
                return new UniversityIdComparator();
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case YEAR_OF_FOUNDATION:
                return new UniversityYearOfFoundationComparator();
            case MAIN_PROFILE:
                return new UniversityMainProfileComparator();
            default:
                throw new IllegalArgumentException("Invalid UniversityComparatorType: " + type);
        }
    }
}