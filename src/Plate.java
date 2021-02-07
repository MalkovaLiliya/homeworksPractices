public class Plate {
    public final int capacityOfPlate = 75;
    int foodInPlate;

    Plate(int foodInPlate)
    {
        if (foodInPlate <= capacityOfPlate)
        this.foodInPlate = foodInPlate;
        else
            this.foodInPlate = capacityOfPlate; //при попытке добавить еды > чем влезет в тарелку
    }

    boolean feedingTheCats(int portion)
    {
        if (foodInPlate >= portion) {
            foodInPlate = foodInPlate - portion;
            return true;
        }
        else {
            System.out.println("В тарелке мало еды для кота!");
            return false;
        }
    }
    void addFood(int food)
    {
        if (foodInPlate < capacityOfPlate && food <= capacityOfPlate-foodInPlate)
            foodInPlate = food + foodInPlate;

        else if (foodInPlate < capacityOfPlate && food > capacityOfPlate-foodInPlate)
            foodInPlate = capacityOfPlate;   //при попытке добавить еды > чем влезет в тарелку

    }

}
