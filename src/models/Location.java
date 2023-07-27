package models;

public class Location {
    private Double x; //Поле не может быть null
    private float y;
    private long z;
    private String name; //Поле может быть null

    public Location(Double x, float y, long z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public long getZ() {
        return z;
    }

    public void setZ(long z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location" +
                "\n\t\t\tx=" + x +
                "\n\t\t\ty=" + y +
                "\n\t\t\tz=" + z +
                "\n\t\t\tname=" + name;
    }
}