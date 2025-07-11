package com.beautyathome.backend.pattern.singleton;

import com.beautyathome.backend.entity.Profesional;
import com.beautyathome.backend.pattern.chain.Handler;

import java.util.*;

public class AgendaManager {

    private static AgendaManager instance;

    private Map<Profesional, List<Date>> agendaProfesional;

    private Handler primerHandler;

    private AgendaManager() {
        agendaProfesional = new HashMap<>();
        inicializarCadena();
    }

    public static AgendaManager getInstance() {
        if (instance == null) {
            instance = new AgendaManager();
        }
        return instance;
    }

    private void inicializarCadena() {
        // Aquí puedes construir tu cadena, por ejemplo:
        // DisponibilidadHandler -> ValidacionFechaHandler -> GuardarHandler
        // primerHandler = new DisponibilidadHandler();
        // primerHandler.setSiguiente(new ValidacionFechaHandler(...));
        // Por ahora, placeholder
        this.primerHandler = null;
    }

    public boolean agendarServicio(Profesional prof, Date fecha) {
        if (primerHandler != null) {
            return primerHandler.procesar(prof, fecha);
        }

        List<Date> disponibles = agendaProfesional.getOrDefault(prof, new ArrayList<>());

        if (disponibles.contains(fecha)) {
            disponibles.remove(fecha);
            agendaProfesional.put(prof, disponibles);
            return true;
        }

        return false;
    }

    public List<Date> obtenerDisponibilidad(Profesional prof) {
        return agendaProfesional.getOrDefault(prof, new ArrayList<>());
    }

    public void registrarDisponibilidad(Profesional prof, List<Date> fechas) {
        agendaProfesional.put(prof, new ArrayList<>(fechas));
    }
}
