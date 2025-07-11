package com.beautyathome.backend.pattern.singleton;

import com.beautyathome.backend.entity.Profesional;
import com.beautyathome.backend.pattern.cor.*;

import java.util.*;

public class AgendaManager {

    private static volatile AgendaManager instance; // thread-safe singleton

    private Map<Profesional, List<Date>> agendaProfesional;
    private Handler primerHandler;

    private AgendaManager() {
        agendaProfesional = new HashMap<>();
        inicializarCadena();
    }

    public static AgendaManager getInstance() {
        if (instance == null) {
            synchronized (AgendaManager.class) {
                if (instance == null) {
                    instance = new AgendaManager();
                }
            }
        }
        return instance;
    }

    private void inicializarCadena() {
        // Crear Handlers con disponibilidad (se puede parametrizar)
        com.beautyathome.backend.pattern.cor.Handler cabello = new HandlerCabello("Cabello", true);
        Handler manicure = new HandlerManicure("Manicure", true);
        Handler pedicure = new HandlerPedicure("Pedicure", true);
        Handler maquillaje = new HandlerMaquillaje("Maquillaje", true);

        // Construir la cadena
        cabello.setSiguiente(manicure);
        manicure.setSiguiente(pedicure);
        pedicure.setSiguiente(maquillaje);

        // Asignar primer handler
        primerHandler = cabello;
    }

    public boolean agendarServicio(Profesional prof, Date fecha) {
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

    public void procesarSolicitud(Solicitud solicitud) {
        if (primerHandler != null) {
            primerHandler.manejarSolicitud(solicitud);
        } else {
            System.out.println("No hay cadena de responsabilidad inicializada.");
        }
    }
}
