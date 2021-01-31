public class Dog extends Animals
{
    private static int countDogs;
    Dog(final String name)
    {
        super(name);
        countDogs++;
    }

    void getCounterCats()

    {
        System.out.println("Количество пёсиков: " + countDogs + " шт.");
    }

    @Override
    void swim(float dist)
    {
        if (dist > 10)
        System.out.println("Пёс " + name + " проплыл 10м из " + dist + "м и больше плыть не может!!!");
        else
            System.out.println("Пёс " + name + " проплыл " + dist + "м");
    }
    @Override
    void run(float dist)
    {
        if (dist > 500)
            System.out.println("Пёс " + name + " пробежал 500м из " + dist + "м и устал");
        else
            System.out.println("Пёс " + name + " пробежал " + dist + "м");
    }
}
