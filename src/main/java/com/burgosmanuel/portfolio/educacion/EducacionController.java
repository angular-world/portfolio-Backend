package com.burgosmanuel.portfolio.educacion;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/educacion")
@Tag(name = "Educaci�n", description = "Se encarga de las operaciones a realizar en los elementos de Educaci�n.")
public class EducacionController {

    @Autowired
    EducacionService service;

    //Anotaciones para la documentaci�n
    @Operation(summary = "Agregar nueva Educaci�n", description = "Sumamos una nueva Educaci�n a la BD para el usuario indicado.")
    @SecurityRequirement(name = "Authorization")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Recurso agregado correctamente."),
        @ApiResponse(responseCode = "400", description = "Hubo un problema en la solicitud."),
        @ApiResponse(responseCode = "401", description = "Usuario no autorizado, inicie sesi�n."),
        @ApiResponse(responseCode = "403", description = "No se puede acceder a este recurso."),
        @ApiResponse(responseCode = "404", description = "No se encontr� el recurso especificado.")})
    // Anotaciones para el Controller
    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public void agregarEducacion(@RequestBody EducacionDTO edu) {
        service.agregarEducacion(edu);
    }

    //Anotaciones para la documentaci�n
    @Operation(summary = "Editar Educaci�n", description = "Editamos informaci�n de la Educaci�n indicada.")
    @SecurityRequirement(name = "Authorization")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Recurso actualizado correctamente."),
        @ApiResponse(responseCode = "400", description = "Hubo un problema en la solicitud."),
        @ApiResponse(responseCode = "401", description = "Usuario no autorizado, inicie sesi�n."),
        @ApiResponse(responseCode = "403", description = "No se puede acceder a este recurso."),
        @ApiResponse(responseCode = "404", description = "No se encontr� el recurso especificado.")})
    // Anotaciones para el Controller

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void editarEducacion(@PathVariable Long id, @RequestBody EducacionDTO datosEducacion) {
        service.editarEducacion(id, datosEducacion);
    }

    //Anotaciones para la documentaci�n
    @Operation(summary = "Listar Educaci�n", description = "Obtenemos una lista de toda la Educaci�n en la BD, posteriormente se filtran en Frontend.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Recursos listados correctamente.")})
    // Anotaciones para el Controller

    @GetMapping("/listar")
    public List<EducacionDTO> listarEducacion() {
        return service.listarEducacion();
    }

    //Anotaciones para la documentaci�n
    @Operation(summary = "Buscar Educaci�n", description = "Obtenemos la informaci�n de una Educaci�n espec�fica a trav�s de la ID.")
    @SecurityRequirement(name = "Authorization")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Recurso listado correctamente."),
        @ApiResponse(responseCode = "400", description = "Hubo un problema en la solicitud."),
        @ApiResponse(responseCode = "401", description = "Usuario no autorizado, inicie sesi�n."),
        @ApiResponse(responseCode = "403", description = "No se puede acceder a este recurso."),
        @ApiResponse(responseCode = "404", description = "No se encontr� el recurso especificado.")})
    // Anotaciones para el Controller

    @GetMapping("/{id}")
    public EducacionDTO buscarEducacion(@PathVariable Long id) {
        return service.buscarEducacion(id);
    }

    //Anotaciones para la documentaci�n
    @Operation(summary = "Eliminar Educaci�n", description = "Eliminamos una Educaci�n seg�n la ID.")
    @SecurityRequirement(name = "Authorization")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Recurso eliminado correctamente."),
        @ApiResponse(responseCode = "400", description = "Hubo un problema en la solicitud."),
        @ApiResponse(responseCode = "401", description = "Usuario no autorizado, inicie sesi�n."),
        @ApiResponse(responseCode = "403", description = "No se puede acceder a este recurso."),
        @ApiResponse(responseCode = "404", description = "No se encontr� el recurso especificado.")})
    // Anotaciones para el Controller
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void borrarEducacion(@PathVariable Long id) {
        service.borrarEducacion(id);
    }
}
