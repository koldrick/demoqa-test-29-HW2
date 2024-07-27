package tests;

import com.github.javafaker.Faker;

public class TestData {


    Faker faker = new Faker();


    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Male","Female","Other");
    public String userNumber = faker.number().digits(10);
    public String yearOfBDay = Integer.toString(faker.number().numberBetween(1950, 2000));
    public String monthOfBDay = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public String dayOfBDay = Integer.toString(faker.number().numberBetween(1, 27));
    public String subject = faker.options().option("Maths", "Accounting", "Arts", "Social Studies", "Biology", "Physics", "Chemistry", "Computer Science", "Commerce", "Economics", "Civics", "Hindi", "English", "History");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String picturePath = "testPhoto.png";
    public String address = faker.address().fullAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = chooseCity();
    public String wrongEmail = faker.name().firstName();

    public String chooseCity() {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            default -> faker.options().option("Jaipur", "Jaipur");
        };

    }
}
