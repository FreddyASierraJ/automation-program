package clase2;

import org.junit.jupiter.api.Test;

public class HerenciaTest {

    @Test
    void estudianteTest()
    {
        Estudiante estudiante = new Estudiante("Juan",17,01);
        estudiante.presentarse();
        estudiante.estudiar();
    }
}
