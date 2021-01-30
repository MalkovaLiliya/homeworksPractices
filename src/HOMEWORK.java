import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class HOMEWORK {

    public static void main(String[] args)
    {
        Workers[] workers = new Workers[5];

        workers[0] = new Workers(
                "Абракадабрин Абрахам Абрамович",
                "Юрист",
                "aaaYU@mail.ru",
                "8-966-458-96-32",
                78895.45f,
                43);

        workers[1] = new Workers(
                "Березкина Барби Борисовна",
                "Экономист",
                "bbb777@gmail.ru",
                "8-458-741-77-11",
                56200.79f,
                26);

        workers[2] = new Workers(
                "Вяленая Волга Ватрушевна",
                "Штамповщица ватных дисков",
                "volgasuper@rambler.ru",
                "8-885-964-77-36",
                35000.01f,
                61);

        workers[3] = new Workers(
                "Гора Григорий Гусиныч",
                "Чистильщик шпунь",
                "grigory11@yandex.ru",
                "8-911-459-96-85",
                4505.85f,
                39);

        workers[4] = new Workers(
                "Дубочки Дарья Дуньевна",
                "Центрировщица оптических изделий",
                "dashaDa@gmail.ru",
                "8-800-555-35-55",
                100155.9f,
                44);

        for (int i = 0; i < workers.length; i++)
        {
            if (workers[i].age > 40)
            {
                workers[i].printInfoInConsole();
            }
        }

    }
}