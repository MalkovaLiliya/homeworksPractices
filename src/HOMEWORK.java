import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class HOMEWORK {

    public static void main(String[] args)
    {
        Cat catKuzya = new Cat("Кузя");
        Cat catPonchik = new Cat("Пончик");
        Cat catWanda = new Cat("Ванда");
        Dog dogBull = new Dog("Буль");
        Dog dogMia = new Dog("Мия");
        Dog dogSummer = new Dog("Самер");
        Dog dogRex = new Dog("Рекс");

        catKuzya.run(15.89f);
        catPonchik.swim(900f);
        catWanda.run(18.75f);
        dogBull.run(759.26f);
        dogMia.swim(356.18f);
        dogRex.run(189f);
        dogSummer.swim(15);

        dogBull.getCounterCats();
        dogBull.getCounterCats();
        dogBull.getCounterAllAnimals();


    }
}