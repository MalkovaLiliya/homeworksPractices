public abstract class Animals {
    protected String name;
    static private int counterAnimals;

    Animals(String name)
    {
        this.name = name;
        counterAnimals++;
    }
    void getCounterAllAnimals()

    {
        System.out.println("Количество всех животных: " + counterAnimals + " шт.");
    }

    abstract void swim(float distanceSwim);
    abstract void run(float distanceRun);

}
