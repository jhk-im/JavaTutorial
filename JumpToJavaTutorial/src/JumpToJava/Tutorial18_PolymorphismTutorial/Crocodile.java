package JumpToJava.Tutorial18_PolymorphismTutorial;

public class Crocodile extends Animal implements Predator, Bark{
    public String getFood(){
        return "people";
    }
    public void bark(){
        System.out.println("쩌어억");
    }
}
