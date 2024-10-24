package pe.edu.cibertec.sw_async_hilos.remote.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AsyncTaskService {

    @Async
    public CompletableFuture<String> operacionPagoOnline() {
        try{
            log.info("Iniciando proceso de pago");
            TimeUnit.SECONDS.sleep(4);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Pago exitoso");
    }

    @Async
    public CompletableFuture<String> operacionRegistroVentas() {
        try{
            log.info("Iniciando registro de ventas");
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Registro de venta exitoso");
    }

    @Async
    public CompletableFuture<String> operacionActualizacionCompras() {
        try {
            log.info("Iniciando actualizacion de compras");
            TimeUnit.SECONDS.sleep(7);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Compra actualizaco");
    }
}
