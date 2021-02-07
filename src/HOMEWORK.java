import java.util.Random;


public class HOMEWORK {
    static Random random = new Random();
    static int portion;
    static int adding;

    public static void main(String[] args)
    {
        Cat catKuzya = new Cat("Кузя");
        Cat catPonchik = new Cat("Пончик");
        Cat catWanda = new Cat("Ванда");
        Cat catBull = new Cat("Буль");
        Cat catMia = new Cat("Мия");
        Cat catSummer = new Cat("Самер");
        Cat catRex = new Cat("Рекс");

        Plate plate = new Plate(100); //в тарелке все равно 75 из-за ограничения вместимости

        catRex.setPortionOfFeeding(50);
        catRex.feedTheCat(plate); //уже не будет годолен при общем кормлении в цикле

        catKuzya.setPortionOfFeeding(80);
        catKuzya.feedTheCat(plate);

        Cat[] cats = {catBull, catMia, catRex, catKuzya, catSummer, catPonchik, catWanda};

        System.out.println("\nВ тарелке " + plate.foodInPlate + " еды. " + cats.length + " шт котиков нужно накормить");
        for (int i = 0; i < cats.length; i++)
        {
            if (cats[i].hunger == false)    //спрашиваем у кота, голоден ли он
            {                               //чтобы генерировать порцию только для голодных котов
                randomSetPortion();
                cats[i].setPortionOfFeeding(portion);
                System.out.println(cats[i].name + " хочет съесть " + portion);
                if (portion > plate.foodInPlate)
                {
                    System.out.println("Недостаточно еды в тарелке. Добавление...");
                    randomAddingFood(plate);
                }
            }
            cats[i].feedTheCat(plate);
            System.out.println("\nВ тарелке осталось " + plate.foodInPlate + " еды.");
        }
    }

     static void randomSetPortion()
    {
        portion = random.nextInt(11) + 1; //минимальная порция кота 1, максимальная 10
    }

    static void randomAddingFood(Plate plate)
    {

        adding = random.nextInt(76);
        int full = adding + (portion - plate.foodInPlate); //минимум:добавляется еды, сколько требуется последнему коту
        plate.addFood(full);
        System.out.println(" В тарелку добавили " + full + ". В тарелке стало " + plate.foodInPlate + " еды");
    }

}