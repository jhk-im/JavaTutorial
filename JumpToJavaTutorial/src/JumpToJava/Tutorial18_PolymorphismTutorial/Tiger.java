package JumpToJava.Tutorial18_PolymorphismTutorial;

public class Tiger extends Animal implements BarkPredator{
    public String getFood(){
        return "pork";
    }
    public void bark(){
        System.out.println("어흥");
    }
}