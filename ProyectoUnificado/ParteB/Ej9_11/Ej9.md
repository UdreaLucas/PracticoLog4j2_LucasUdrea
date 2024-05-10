La clase `ThreadContext` es parte de la API Log4j 2 y se utiliza para manejar el contexto del hilo en registros de aplicaciones Java. Este contexto se refiere a información adicional asociada con cada hilo en la aplicación. En versiones anteriores de Log4j, esta funcionalidad se dividía en MDC (Contexto de Diagnóstico Mapeado) y NDC (Contexto de Diagnóstico Anidado). En Log4j 2, estos conceptos se combinan en un único Thread Context (Contexto de Hilo), que incluye un Mapa de Contexto de Hilo (Thread Context Map) similar al MDC y una Pila de Contexto de Hilo (Thread Context Stack) similar al NDC.

El Thread Context Map permite agregar y recuperar información utilizando pares clave-valor, mientras que la Thread Context Stack permite apilar y desapilar elementos para mantener un orden específico de contexto.

Una forma común de utilizar el Thread Context es para etiquetar eventos de registro de manera única, especialmente en sistemas multihilo. Esto se conoce como Fish Tagging, donde cada solicitud o transacción puede ser marcada con datos comunes para rastrear su flujo completo. Log4j proporciona métodos para realizar Fish Tagging, ya sea utilizando el Thread Context Map o la Thread Context Stack.

Log4j 2 también ofrece la clase `CloseableThreadContext`, que implementa la interfaz `AutoCloseable` para facilitar la limpieza del contexto del hilo después de su uso. Esto es útil para evitar fugas de memoria y garantizar la limpieza adecuada del contexto del hilo, especialmente en entornos de subprocesos.

En cuanto a la configuración, se pueden desactivar el Thread Context Map y/o la Thread Context Stack mediante propiedades del sistema, y también se puede habilitar la herencia del Thread Context Map en subprocesos hijos.

Además, Log4j 2 proporciona mecanismos para incluir el contenido del Thread Context en los patrones de salida de los registros, lo que facilita la inclusión de esta información en los registros generados por la aplicación.

En resumen, `ThreadContext` en Log4j 2 es una herramienta poderosa para manejar información adicional asociada con hilos en aplicaciones Java, lo que facilita el seguimiento y la depuración en entornos multihilo.


Ejemplo:

```java
try (final CloseableThreadContext.Instance ctc = CloseableThreadContext.put("id", UUID.randomUUID().toString())
.put("ipAddress", request.getRemoteAddr())
.put("loginId", session.getAttribute("loginId"))
.put("hostName", request.getServerName())) {
logger.debug("Message 1");
// Resto del código aquí
logger.debug("Message 2");
} // Los MDC (Mapped Diagnostic Context) se limpian automáticamente al salir de este bloque
```