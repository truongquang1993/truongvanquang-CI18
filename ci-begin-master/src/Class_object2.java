public class Class_object2 {
    public static void main(String[] args) {
//        Tạo mới đối tượng từ Class
        Class_object human1 = new Class_object();
        human1.printName();
        System.out.println(Class_object.genders[0]);

//        Khai báo thêm hàm tạo tùy mục đích sử dụng cho class
//        ví dụ: Muối đặt name, age cho đối tượng tạo ra
        Class_object human2 = new Class_object("Quang", 26);
        human2.printName();

    }
}
