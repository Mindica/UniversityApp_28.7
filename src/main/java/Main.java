import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try (InputStream config = Main.class.getClassLoader().getResourceAsStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(config);
        } catch (IOException e) {
            System.err.println("Could not load logging configuration: " + e);
        }

        logger.log(Level.INFO, "Application started");

        try {
            University university1 = new University()
                    .setId("BMSTU")
                    .setFullName("Bauman Moscow State Technical University")
                    .setShortName("BMSTU")
                    .setYearOfFoundation(1830)
                    .setMainProfile(StudyProfile.ENGINEERING);

            University university2 = new University()
                    .setId("MSU")
                    .setFullName("Moscow State University")
                    .setShortName("MSU")
                    .setYearOfFoundation(1755)
                    .setMainProfile(StudyProfile.ECONOMICS);

            Student student1 = new Student()
                    .setFullName("Ivanov Ivan")
                    .setUniversityId("BMSTU")
                    .setCurrentCourseNumber(3)
                    .setAvgExamScore(4.7f)
                    .setStudyProfile(StudyProfile.ENGINEERING); // Задаём studyProfile

            Student student2 = new Student()
                    .setFullName("Petrov Petr")
                    .setUniversityId("MSU")
                    .setCurrentCourseNumber(2)
                    .setAvgExamScore(4.9f)
                    .setStudyProfile(StudyProfile.ECONOMICS); // Задаём studyProfile

            List<University> universities = new ArrayList<>();
            universities.add(university1);
            universities.add(university2);
            logger.log(Level.INFO, "Created a list of universities. Size: {0}", universities.size());

            List<Student> students = new ArrayList<>();
            students.add(student1);
            students.add(student2);
            logger.log(Level.INFO, "Created a list of students. Size: {0}", students.size());

            // Сбор статистики
            List<Statistics> statistics = CollectionUtil.collectStatistics(students, universities);
            logger.log(Level.INFO, "Collected statistics. Number of statistics records: {0}", statistics.size());

            // Генерация Excel-файла
            String excelFilePath = "statistics.xlsx";
            logger.log(Level.INFO, "Generating Excel file: {0}", excelFilePath);
            XlsWriter.generateExcel(statistics, excelFilePath);
            logger.log(Level.INFO, "Excel file generated successfully: {0}", excelFilePath);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error during Excel file operations: ", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An unexpected error occurred: ", e);
        } finally {
            logger.log(Level.INFO, "Application finished");
        }
    }
}