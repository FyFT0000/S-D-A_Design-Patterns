
/* 
You are working in an office with an old coffee machine that dispenses two different coffee flavours. However, the new boss wants to add a new coffee machine with a touchscreen that can also connect to the old coffee machine. Complete the provided code to add an adapter so that the new touchscreen will  to work with the old coffee machine. Use the following UML class diagram for a guide: 
*/

//CoffeeMachineInterface.java
public interface CoffeeMachineInterface {

    public void chooseFirstSelection();
    public void chooseSecondSelection();
    
}


//OldCoffeeMachine.java
public class OldCoffeeMachine {

    public void selectA() {
        System.out.println("A - Selected");
    }

    public void selectB() {
        System.out.println("B - Selected");
    }

}


//CoffeeTouchscreenAdapter.java
public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {

    private OldCoffeeMachine oldVendingMachine;

    public CoffeeTouchscreenAdapter(OldCoffeeMachine vendingMachine) {
        oldVendingMachine = vendingMachine;
    }

    @Override
    public void chooseFirstSelection() {
        oldVendingMachine.selectA();
    }

    @Override
    public void chooseSecondSelection() {
        oldVendingMachine.selectB();
    }

}
