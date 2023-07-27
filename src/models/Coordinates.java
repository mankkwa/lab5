package models;

public class Coordinates {
    private Double x; //Поле не может быть null
    private Long y; //Максимальное значение поля: 873, Поле не может быть null

    public Coordinates(Double x, Long y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates" +
                "\n\t\tx=" + x +
                "\n\t\ty=" + y;
    }
}