package clase2;

import org.junit.jupiter.api.Test;

public class Vehiculo_Test {

    @Test

    void vehiculoTest()
    {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMarca("Mazda");
        vehiculo.setModelo("CX-30");
        vehiculo.setColor("Rojo Diamante");
        vehiculo.setYear(2022);

        vehiculo.encender();
        vehiculo.acelerar(20);
        vehiculo.mostrarInformacion();
    }
}
