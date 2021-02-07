public class Cat extends Animals
{
    private static int countCats;
    int portionOfCat;
    public boolean hunger = false;
    Cat(final String name)
    {
        super(name);
        countCats++;
    }

    void setPortionOfFeeding(int portion)
    {
        portionOfCat = portion;
    }

    void feedTheCat(Plate plate)
    {
        if (hunger == true) //не кормить сытого кота
            System.out.println("Котик " + name + " не голоден");
        else {
            hunger = plate.feedingTheCats(portionOfCat);
            if (hunger == true)
                System.out.println("Котик " + name + " теперь сытый");
            else
                System.out.println("Котик " + name + " остался голодным");
        }
    }

    void getCounterCats()
    {
        System.out.println("Количество котиков: " + countCats + " шт.");
    }

    @Override
    void swim(float dist)
    {
        System.out.println("Упс! Котик " + name + " не умеет плавать");
    }
    @Override
    void run(float dist)
    {
        if (dist > 200)
            System.out.println("Котик " + name + " пробежал 200м из " + dist + "м и устал");
        else
            System.out.println("Котик " + name + " пробежал " + dist + "м");
    }

}
