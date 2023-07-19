package com.nvooaj.apptarea.service;

import com.nvooaj.apptarea.entity.Tarea;
import com.nvooaj.apptarea.exception.TareaException;
import com.nvooaj.apptarea.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;
    public List<Tarea> listarTareas(){
        return tareaRepository.findAll();
    }

    public Tarea agregarTarea(Tarea tarea){
        Tarea savedTarea = new Tarea();
        if(tarea.getId()==null){
            savedTarea =tareaRepository.save(tarea);
        }else {
            savedTarea = tareaRepository.save(tarea);
        }
        return savedTarea;
    }

    public Tarea editarTarea(Tarea tarea){
        Optional<Tarea> tareaData = tareaRepository.findById(tarea.getId());

        if (tareaData.isPresent()) {
            Tarea _tarea = tareaData.get();

            _tarea.setDescripcion(tarea.getDescripcion());
            _tarea.setFechaCreacion(tarea.getFechaCreacion());
            _tarea.setVigente(tarea.isVigente());
            return tareaRepository.save(_tarea);
        }else{
            return null;
        }

    }

    public boolean remover(Long id){
        Optional<Tarea> tarea = tareaRepository.findById(id);
        if(tarea.isPresent()){
            tareaRepository.delete(tarea.get());
            return true;
        }
        throw new TareaException("Tarea with "+id+" does not exists!");
    }
}
