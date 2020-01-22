public class Tiger extends Predator implements Bark{
    public String getFood(){
        return "pork";
    }
    public void bark(){
        System.out.println("어흥");
    }

    // --> Predator 에 isPredator 를
    // Predator 를 상속받은 클래스에서 사용 가능하다.
    @Override
    public boolean isPredator() {
        return super.isPredator();
    }
}