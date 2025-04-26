package clase2;

public class Vehiculo {

    private String marca;
    private String modelo;
    private int year;
    private String color;
    private int velocidad;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //metodos de la clase vehiculo

    public void encender()
    {
        System.out.println("Vehiculo encendido");

    }

    public void acelerar(int cantidad)
    {
        velocidad +=cantidad;
        System.out.println("acelerando....velocidad actual: "+velocidad+" kms/h");
    }

    public void mostrarInformacion()
    {
        System.out.println("Marca: "+ marca);
        System.out.println("Modelo: "+ modelo);
        System.out.println("año: "+year);
        System.out.println("Color: "+ color);

    }

}
