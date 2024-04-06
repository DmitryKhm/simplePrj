import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\\Меню:");
            System.out.println("1. Добавить нового студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Обновить оценки");
            System.out.println("4. Просмотреть все оценки");
            System.out.println("5. Просмотреть оценки конкретного студента");
            System.out.println("6. Загрузить файл");
            System.out.println("7. Сохранить в файл");
            System.out.println("8. Выйти");
            System.out.print("Введите символ: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> GradeMenu.addStudent(scanner.nextLine());
                case 2 -> GradeMenu.deleteStudent(scanner.nextLine());
                case 3 -> GradeMenu.updateStudentGrade(scanner.nextLine(), scanner.nextLine(), Integer.parseInt(scanner.nextLine()));
                case 4 -> GradeMenu.getAllGrades();
                case 5 -> GradeMenu.getStudentGrade(scanner.nextLine());
                case 6 -> GradeMenu.loadGradesFromFile(scanner.nextLine());
                case 7 -> GradeMenu.saveGradesToFile(scanner.nextLine());
                case 8 -> System.out.println("Выход из программы.");
                default -> System.out.println("Что-то пошло не так.");
            }

        } while (choice != 8);
    }
}