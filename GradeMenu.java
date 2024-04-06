import java.io.*;
import java.lang.constant.Constable;
import java.util.HashMap;
import java.util.Map;

public class GradeMenu {

    private static final Map<String, Integer> studentSubjectsMap = new HashMap<>();

    private final static String regex = "[а-яёА-ЯЁ]+";

    public static void addStudent(String name) {

        if (!name.matches(regex)) {
            System.out.println("Можно вводить только кириллические символы");
        }

        studentSubjectsMap.put(name, null);
    }

    public static Object deleteStudent(String name) {
        return studentSubjectsMap.entrySet().removeIf(entry -> studentSubjectsMap.containsKey(name));
    }

    public static Constable updateStudentGrade(String name, String subj, int grade) {
        return studentSubjectsMap.put(name + " " + subj, grade);
    }

    public static void getAllGrades() {

        if (studentSubjectsMap.isEmpty()) {
            System.out.println("Студентов нет");
        }

        studentSubjectsMap.entrySet().stream()
                .filter(studentSubjectsMap -> studentSubjectsMap.getValue() != null)
                .forEach(System.out::println);
    }

    public static void getStudentGrade(String name) {
        System.out.println("Введите имя");

        if (!name.matches(regex)) {
            System.out.println("Можно вводить только кириллические символы");
        }

        if (studentSubjectsMap.isEmpty()) {
            System.out.println("Студент не найден");
        }

        studentSubjectsMap.entrySet().stream()
                .filter(stringIntegerEntry -> stringIntegerEntry.getKey()
                .contains(name)).forEach(System.out::println);
    }

    public static void loadGradesFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String key = parts[0];
                int value = Integer.parseInt(parts[1]);
                studentSubjectsMap.put(key, value);
            }
            System.out.println("Загрузка завершена.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка.");
        }
    }

    public static void saveGradesToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Integer> entry : studentSubjectsMap.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
            System.out.println("Выгрузка завершена.");
        } catch (IOException e) {
            System.out.println("Произошел сбой.");
        }
    }
}