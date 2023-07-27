package models;

public class Address {
    private String street; //Поле не может быть null
    private Location town; //Поле не может быть null

    public Address(String street, Location town) {
        this.street = street;
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Location getTown() {
        return town;
    }

    public void setTown(Location town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address" +
                "\n\t\tstreet=" + street +
                "\n\t\ttown=" + town;
    }
}