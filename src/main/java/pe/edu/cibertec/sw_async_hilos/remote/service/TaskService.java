package pe.edu.cibertec.sw_async_hilos.remote.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class TaskService {

    public String metodo1() {
        log.info("METODO 1");
        try {
            TimeUnit.SECONDS.sleep(4);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "metodo1";
    }

    public String metodo2() {
        log.info("METODO 2");
        try {
            TimeUnit.SECONDS.sleep(7);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "metodo2";
    }

    public String metodo3() {
        log.info("METODO 3");
        try {
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "metodo3";
    }
}
