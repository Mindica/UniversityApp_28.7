import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionUtil {

    private CollectionUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Statistics> collectStatistics(Collection<Student> students, Collection<University> universities) {
        // Group students by study profile
        Map<String, List<Student>> studentsByProfile = students.stream()
                .collect(Collectors.groupingBy(student -> student.getStudyProfile().getProfileName()));

        // Collect unique university IDs for each profile
        Map<String, Set<String>> universityIdsByProfile = studentsByProfile.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .map(student -> student.getUniversityId())
                                .collect(Collectors.toSet())
                ));

        // Create Statistics objects for each study profile
        return universityIdsByProfile.entrySet().stream()
                .map(entry -> {
                    String profile = entry.getKey();
                    Set<String> universityIds = entry.getValue();

                    // Calculate average grade for the profile
                    OptionalDouble averageGrade = studentsByProfile.get(profile).stream()
                            .mapToDouble(Student::getAvgExamScore)
                            .average();

                    Double avgGrade = averageGrade.isPresent() ? averageGrade.getAsDouble() : null;

                    // Count students for the profile
                    int studentsCount = studentsByProfile.get(profile).size();

                    // Collect university names for the profile
                    List<String> universityNames = universities.stream()
                            .filter(university -> universityIds.contains(university.getId()))
                            .map(University::getFullName)
                            .collect(Collectors.toList());

                    // Create a Statistics object for each university in the profile
                    return universityNames.stream()
                            .map(universityName -> new Statistics(
                                    profile,
                                    avgGrade,
                                    studentsCount,
                                    universityIds.size(),
                                    universityName
                            ))
                            .collect(Collectors.toList());
                })
                .flatMap(Collection::stream) // Flatten the list of lists into a single list
                .collect(Collectors.toList());
    }
}