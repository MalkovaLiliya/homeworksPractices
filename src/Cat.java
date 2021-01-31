public class Cat extends Animals
{
    private static int countCats;
    Cat(final String name)
    {
        super(name);
        countCats++;
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
