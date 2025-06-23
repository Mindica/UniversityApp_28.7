import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Application started");

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
            logger.info("Created a list of universities. Size: {}", universities.size());

            List<Student> students = new ArrayList<>();
            students.add(student1);
            students.add(student2);
            logger.info("Created a list of students. Size: {}", students.size());

            // Сбор статистики
            List<Statistics> statistics = CollectionUtil.collectStatistics(students, universities);
            logger.info("Collected statistics. Number of statistics records: {}", statistics.size());

            // Генерация Excel-файла
            String excelFilePath = "statistics.xlsx";
            logger.info("Generating Excel file: {}", excelFilePath);
            XlsWriter.generateExcel(statistics, excelFilePath);
            logger.info("Excel file generated successfully: {}", excelFilePath);

        } catch (IOException e) {
            logger.error("Error during Excel file operations: ", e);
        } catch (Exception e) {
            logger.error("An unexpected error occurred: ", e);
        } finally {
            logger.info("Application finished");
        }
    }
}