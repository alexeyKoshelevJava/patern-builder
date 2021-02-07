public class Main {
    public static void main(String[] args) {
        Person mom = new Person.Builder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        System.out.println(mom.hasAddress());

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        mom.happyBirthday();
        System.out.println("У " + mom + " есть сын, " + son);
        try {
            // Не хватает обязательных полей
            new Person.Builder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new Person.Builder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
}

