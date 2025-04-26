package clase2;

public class Estudiante extends Persona
{
    int estudianteId;

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Estudiante(String nombre, int edad, int estudianteId) {
        super(nombre, edad);
        this.estudianteId=estudianteId;
    }
    public void estudiar()
    {
        System.out.println("el id de "+getNombre()+" es "+getEstudianteId());
    }
}
