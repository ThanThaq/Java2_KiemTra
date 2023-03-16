import java.util.Scanner;
import dao.StudentDAO;
import model.Student;
import java.util.List;

public class App {

    private static void mainMenu() {
        System.out.println("--- QUẢN LÝ THÔNG TIN SINH VIÊN ---");
        System.out.println("1. Danh sách sinh viên theo bảng");
        System.out.println("2. Nhập một sinh viên mới");
        System.out.println("3. Xóa một sinh viên theo mã");
        System.out.println("4. Cập nhật thông tin sinh viên");
        System.out.println("5. Tìm một sinh viên theo họ tên hoặc mã");
        System.out.println("6. Sắp xếp sinh viên theo điểm số GPA tăng dần");
        System.out.println("7. In ra tất cả các sinh viên nữ ở Hà Nội có GPA trên 2.5");
        System.out.println("8. Sắp xếp sinh viên theo họ tên");
        System.out.println("0. Thoát");
    }

    private static void option1() {
        List<Student> studentList = StudentDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            System.out.printf("%-20s %-20s %-20d %-20s\n", s.getId(), s.getFull_name(), s.getGender(), s.getAddress());
        };
    }
    private static void option2(Scanner in){
        Student s = new Student();
        System.out.print("\tNhập mã sinh viên: ");
        s.setId(in.nextLine());
        System.out.print("\tNhập tên sinh viên: ");
        s.setFull_name(in.nextLine());
        System.out.print("\tNhập giới tính: ");
        s.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("\tNhập ngày sinh: ");
        s.setBirthday(in.nextLine());
        System.out.print("\tNhập địa chỉ: ");
        s.setAddress(in.nextLine());
        System.out.print("\tNhập số điện thoại: ");
        s.setPhone(in.nextLine());
        System.out.print("\tNhập email: ");
        s.setEmail(in.nextLine());
        System.out.print("\tNhập điểm GPA: ");
        s.setGPA(Double.parseDouble(in.nextLine()));
        StudentDAO.insert(s);
        List<Student> studentList = StudentDAO.getAll();
        System.out.println(studentList);
    }
    private static void option3(Scanner in){
        System.out.println("Nhập mã sinh viên muốn xóa: ");
        String id = in.nextLine();
        StudentDAO.delete(id);
        List<Student> studentList = StudentDAO.getAll();
        System.out.println(studentList);
    }

    public static void option4(Scanner in){
        System.out.print("\tNhập mã sinh viên muốn cập nhật : ");
        String id = in.nextLine();
        Student studentList = StudentDAO.getById(id);
        System.out.println(studentList);
        Student s = new Student();
        System.out.print("\tNhập tên sinh viên mới: ");
        s.setFull_name(in.nextLine());
        System.out.print("\tNhập giới tính mới: ");
        s.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("\tNhập ngày sinh mới: ");
        s.setBirthday(in.nextLine());
        System.out.print("\tNhập địa chỉ mới: ");
        s.setAddress(in.nextLine());
        System.out.print("\tNhập số điện thoại mới: ");
        s.setPhone(in.nextLine());
        System.out.print("\tNhập email mới: ");
        s.setEmail(in.nextLine());
        System.out.print("\tNhập điểm GPA mới: ");
        s.setGPA(Double.parseDouble(in.nextLine()));
        StudentDAO.update(s,id);
        List<Student> studentLists = StudentDAO.getAll();
        System.out.println(studentLists);
    }

    private static void option6() {
        List<Student> studentList = StudentDAO.SortbyGPA();
        System.out.println(studentList);
    }
    private static void option7() {
        List<Student> studentList = StudentDAO.getGirlandSort();
        System.out.println(studentList);
    }
    private static void option8() {
        List<Student> studentList = StudentDAO.getAllandSort();
        System.out.println(studentList);
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int option = -1;

        do {
            mainMenu();
            System.out.print("Nhập lựa chọn: ");
            option = Integer.parseInt(in.nextLine());
            // Làm thêm phàn try-catch khi người dùng nhập lỗi
            if (option < 1 || option > 8) {
                System.out.println("Vui lòng nhập lại!");
                continue;
            }
            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2(in);
                    break;
                case 3:
                    option3(in);
                    break;
                case 4:
                    option4(in);
                    break;
                case 5:
                    break;
                case 6:
                    option6();
                    break;
                case 7:
                    option7();
                    break;
                case 8:
                    option8();
                    break;
            }

        }
        while (option != 0);
        in.close();

    }
}
