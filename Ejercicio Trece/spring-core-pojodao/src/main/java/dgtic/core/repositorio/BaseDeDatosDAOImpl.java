package dgtic.core.repositorio;

import dgtic.core.modelo.Estudiante;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("baseDeDatosDAOUno")
//@Primary

public class BaseDeDatosDAOImpl implements BaseDeDatosDAO {

    @Override
    public List<Estudiante> getEstudiantes(String carrera) {
        return BaseDeDatos.carreras.get(carrera);
    }

    @Override
    public Estudiante getEstudiante(String carrera, String matricula) {
        return BaseDeDatos.carreras.get(carrera)
                .stream().filter(estudiante ->
                        estudiante.getMatricula().equals(matricula))
                .findFirst().get(); //hacer flujos (te da el objeto y lo guarda temporalmente), a partir de la version 8, stream trae el flujo de la base de datos
    }
}
