package pe.edu.cibertec.sw_async_hilos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_async_hilos.remote.service.AsyncTaskService;
import pe.edu.cibertec.sw_async_hilos.remote.service.TaskService;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Service
public class AtencionService {

    private final AsyncTaskService asyncTaskService;
    private final TaskService taskService;

    public CompletableFuture<String> ejecutarTareasAsincronas() {
        CompletableFuture<String> tarea1 = asyncTaskService.operacionPagoOnline();
        CompletableFuture<String> tarea2 = asyncTaskService.operacionRegistroVentas();
        CompletableFuture<String> tarea3 = asyncTaskService.operacionActualizacionCompras();

        return CompletableFuture.allOf(tarea1, tarea2, tarea3).thenApply(result -> {
            try {
                String valorTarea1 = tarea1.join();
                String valorTarea2 = tarea2.join();
                String valorTarea3 = tarea3.join();
                return "Resultado Final = " + valorTarea1 + " - " + valorTarea2 + " - " + valorTarea3;
            }catch (Exception e) {
                return "Error al combinar los datos";
            }
        });
    }

    public String tareas2() {
        String tarea1 = taskService.metodo1();
        String tarea2 = taskService.metodo2();
        String tarea3 = taskService.metodo3();
        return "Resultado Final : " + tarea1 + " - " + tarea2 + " - " + tarea3;
    }
}
