// Lớp dùng để định nghĩa đối tượng, lớp đóng vai trò là một khung có sẵn, mỗi khi cần tạo đối tượng
// để sử dụng sẽ gọi đến class để tạo mới
public class Class_object {
    //    thuộc tính
//    Thuộc tính static được tạo kèm ra trong mỗi class
    public static String[] genders = {"male", "female"};

    // thuộc tính non-static -> được tạo kèm với mỗi đối tượng
    public String name;
    public int age;

    //    hàm tạo
    public Class_object() {
        this.name = "New person";
        this.age = 22;
    }

    public Class_object(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //    Phuong thuc
    public void printName() {
        System.out.println(this.name);
    }
}
