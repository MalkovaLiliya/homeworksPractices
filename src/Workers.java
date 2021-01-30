public class Workers {
    String fullName;
    String post;
    String email;
    String phoneNumber;
    float salary;
    int age;

    Workers(String fullName, String post, String email, String phone, float salary, int age)
    {
    this.fullName = fullName;
    this.post = post;
    this.email = email;
    phoneNumber = phone;
    this.salary = salary;
    this.age = age;
    }

    void printInfoInConsole()
    {
        System.out.println("\nФИО " + fullName);
        System.out.println("Должность " + post);
        System.out.println("email " + email);
        System.out.println("Телефон " +  phoneNumber);
        System.out.println("Зарплата " + salary + " рублей");
        System.out.println("Возраст " + age);
    }

}
