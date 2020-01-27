package JumpToJava.Tutorial18_PolymorphismTutorial;

public class Leopard extends Animal implements Predator, Bark {
    public String getFood(){
        return "chicken";
    }
    public void bark(){
        System.out.println("키야옹");
    }
}
