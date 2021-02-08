import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        if (age == -1) {
            return false;
        } else return true;


    }

    public void setAddress(String address) {
        if (hasAddress() == false) {
            this.address = address;
        }
    }

    public boolean hasAddress() {
        if (address == null) {
            return false;
        } else {
            return true;

        }


    }

    public void happyBirthday() {
        if (hasAge() == true) {
            age = age + 1;
        }

    }

    public Builder newChildBuilder() {
        return new Person.Builder()
                .setSurname(surname)
                .setAddress(address)
                .setAge(0)
                ;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private String name;
        private String surname;
        private int age = -1;
        private String address;

        public Builder() {

        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setAge(int val) {
            if (val < 0) {
                throw new IllegalArgumentException("field age can't be less then 0");
            } else {
                this.age = val;
                return this;
            }
        }

        public Builder setAddress(String val) {
            this.address = val;
            return this;
        }

        public Person build() {
            if (name == null || surname == null) {
                throw new IllegalStateException("не заполнены обязательные поля");
            }
            if (age == -1) {
                Person person = new Person(name, surname);
                person.age = age;
                person.address = address;
                return person;
            } else {
                Person person = new Person(name, surname, age);

                person.address = address;
                return person;
            }

        }

    }

}

