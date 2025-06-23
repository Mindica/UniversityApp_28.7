import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;

public class JsonUtil {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JsonUtil() {
        // Запрещаем создание экземпляров класса
        throw new IllegalStateException("Utility class");
    }

    public static String serializeStudent(Student student) {
        return gson.toJson(student);
    }

    public static Student deserializeStudent(String json) {
        return gson.fromJson(json, Student.class);
    }

    public static String serializeUniversity(University university) {
        return gson.toJson(university);
    }

    public static University deserializeUniversity(String json) {
        return gson.fromJson(json, University.class);
    }

    public static String serializeStudents(Collection<Student> students) {
        return gson.toJson(students);
    }

    public static Collection<Student> deserializeStudents(String json) {
        Type studentListType = new TypeToken<Collection<Student>>(){}.getType();
        return gson.fromJson(json, studentListType);
    }

    public static String serializeUniversities(Collection<University> universities) {
        return gson.toJson(universities);
    }

    public static Collection<University> deserializeUniversities(String json) {
        Type universityListType = new TypeToken<Collection<University>>(){}.getType();
        return gson.fromJson(json, universityListType);
    }
}