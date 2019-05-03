public class Human {
    //Thuoc tinh
    String name;
    int age;
    String gender;

    //    Ham tao
    public Human() {//Ham tao rong
        name = "new person";
        age = 20;
        gender = "male";
    }

    //    Ham tao day du truyen vao tat ca thuoc tinh
    public Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //Phuong thuc
    public void eat() {
        System.out.println(name + " eating...");
    }

    public void sleep() {
        System.out.println(name + " sleeping ...");
    }
}
