public class Empoyee extends Human {
    //    name
//    age
//    gender
    @Override
    public void eat() {
        super.eat(); // Van co the dung lai cua cha
        System.out.println(name + " eating done!");
    }

}
