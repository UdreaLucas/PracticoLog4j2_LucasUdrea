package practicolog4j.ej56;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ej56 {

    private static final Logger logger = LogManager.getLogger(Ej56.class);

    public static void main(String[] args) {
        logger.info("Este es un mensaje de info del ej 5 y 6");

        // Loggeamos un mensaje de error luego de 1 minuto y medio
        try {
            Thread.sleep(90000);
        } catch (Exception e) {
            logger.error("Error al dormir el hilo", e);
        } finally {
            logger.warn("Este es un mensaje de advertencia luego de 1 minuto y medio");
        }
    }
}
