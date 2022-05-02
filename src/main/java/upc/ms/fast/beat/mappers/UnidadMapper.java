package upc.ms.fast.beat.mappers;

import org.springframework.stereotype.Component;
import upc.ms.fast.beat.entity.Unidad;
import upc.ms.fast.beat.types.UnidadDTO;

import java.util.Objects;

@Component
public class UnidadMapper {


    public UnidadDTO parseUnidadDTO(Unidad unidad){
        return UnidadDTO.builder()
                .color(unidad.color)
                .estado_id(unidad.estado_id)
                .id(unidad.id)
                .marca(unidad.marca)
                .modelo(unidad.modelo)
                .kilometraje(unidad.kilometraje)
                .nro_motor(unidad.nro_motor)
                .nro_placa(unidad.nro_placa)
                .nro_serie(unidad.nro_serie)
                .sede_id(unidad.sede_id)
                .build();
    }

    public Unidad parseUnidad(UnidadDTO unidad){
        return Unidad.builder()
                .color(unidad.color)
                .estado_id(unidad.estado_id)
                .id(unidad.id)
                .marca(unidad.marca)
                .modelo(unidad.modelo)
                .kilometraje(unidad.kilometraje)
                .nro_motor(unidad.nro_motor)
                .nro_placa(unidad.nro_placa)
                .nro_serie(unidad.nro_serie)
                .sede_id(unidad.sede_id)
                .build();
    }

    public Unidad updateUnidad(Unidad request, Unidad toUpdate){

        if(Objects.nonNull(request.getColor())){
            toUpdate.setColor(request.getColor());
        }

       /*if(Objects.nonNull(request.getEstado_id())){
            toUpdate.setEstado_id(request.getEstado_id());
        }*/

        if(Objects.nonNull(request.getMarca())){
            toUpdate.setMarca(request.getMarca());
        }

        if(Objects.nonNull(request.getModelo())){
            toUpdate.setModelo(request.getModelo());
        }

        if(Objects.nonNull(request.getKilometraje())){
            toUpdate.setKilometraje(request.getKilometraje());
        }

        if(Objects.nonNull(request.getNro_motor())){
            toUpdate.setNro_motor(request.getNro_motor());
        }

        if(Objects.nonNull(request.getNro_placa())){
            toUpdate.setNro_placa(request.getNro_placa());
        }

        if(Objects.nonNull(request.getNro_serie())){
            toUpdate.setNro_serie(request.getNro_serie());
        }

        /*if(Objects.nonNull(request.getSede_id())){
            toUpdate.setSede_id(request.getSede_id());
        }*/
        return toUpdate;
    }
}
