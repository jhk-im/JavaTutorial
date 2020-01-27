package JumpToJava.Tutorial18_PolymorphismTutorial;

public class Lion extends Animal implements Predator, Bark{
    public String getFood(){
        return "beef";
    }
    public void bark(){
        System.out.println("으르렁");
    }
}