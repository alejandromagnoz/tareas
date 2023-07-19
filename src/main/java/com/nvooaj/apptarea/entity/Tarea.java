package com.nvooaj.apptarea.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Descripcion cann't be blank")
    @Size(min = 2,max = 30)
    private String descripcion;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("fechaCreacion")
    private Date fechaCreacion;

    @NotNull
    private boolean vigente;
    @ApiModelProperty(example = "18/07/2023 14:02:54", required = true, value = "Date de creacion.")
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @ApiModelProperty(example = "Debe ser una cadena de largo minimo 2 y maximo 30", required = true, value = "Descripción de la tarea.")
    @NotNull
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @ApiModelProperty(example = "El valor debe ser true o false", required = true, value = "Vigencia de la tarea.")
    @NotNull
    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
}
