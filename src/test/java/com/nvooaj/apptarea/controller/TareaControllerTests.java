package com.nvooaj.apptarea.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.nvooaj.apptarea.entity.Tarea;
import com.nvooaj.apptarea.service.TareaService;
import com.nvooaj.apptarea.service.ValidationErrorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Date;

@RunWith(SpringRunner.class)
@WebMvcTest(TareaController.class)
public class TareaControllerTests {
    @MockBean
    private TareaService service;

    @MockBean
    private ValidationErrorService validationService;

    @Autowired
    private MockMvc mockMvc;

    ResponseEntity<String> responseCreated = new ResponseEntity<String>(HttpStatus.CREATED);
    ResponseEntity<String> responseOk = new ResponseEntity<String>(HttpStatus.OK);
    ResponseEntity<String> responseNotOK = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

    @Test
    public void shouldCreateTarea() {
        try {
            HttpHeaders headers = new HttpHeaders();

            Tarea tarea = new Tarea();
            tarea.setId(new Long(1));
            tarea.setVigente(true);
            tarea.setDescripcion("texto descripcion");
            tarea.setFechaCreacion(new Date());

            Mockito.when(service.agregarTarea(any()))
                    .thenReturn(tarea);

            MvcResult mvcResult = mockMvc
                    .perform(post("/tareas").headers(headers).content(getJsonTareaRequest())
                            .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                    .andDo(print()).andReturn();

            assertEquals("response ok: ", responseCreated.getStatusCode().value(),
                    mvcResult.getResponse().getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void shouldCreateTareaInternalError() {
        try {
            HttpHeaders headers = new HttpHeaders();
            Mockito.when(service.agregarTarea(any())).thenThrow();

            MvcResult mvcResult = mockMvc
                    .perform(post("/tareas").headers(headers).content(getJsonTareaRequest())
                            .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                    .andDo(print()).andReturn();

            assertEquals("response does not match: ", responseNotOK.getStatusCode().value(),
                    mvcResult.getResponse().getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void shouldEditarTarea() {
        try {
            HttpHeaders headers = new HttpHeaders();

            Tarea tarea = new Tarea();
            tarea.setId(new Long(1));
            tarea.setVigente(true);
            tarea.setDescripcion("texto descripcion");
            tarea.setFechaCreacion(new Date());

            Mockito.when(service.editarTarea(any()))
                    .thenReturn(tarea);

            MvcResult mvcResult = mockMvc
                    .perform(put("/tareas/1")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(getJsonTareaRequest()))
                    .andDo(print()).andReturn();

            assertEquals("response does not match: ", responseOk.getStatusCode().value(),
                    mvcResult.getResponse().getStatus());


            assertEquals("response ok: ", responseOk.getStatusCode().value(),
                    mvcResult.getResponse().getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getJsonTareaRequest() {
        return "{\r\n" + "  \"id\": 1,\r\n" + "    \"fechaCreacion\": \"18/07/2023 14:02:54\",\r\n" + "    \"descripcion\": \"texto descripcion\",\r\n"
                + "    \"vigente\": true\r\n" + "}";
    }
}


