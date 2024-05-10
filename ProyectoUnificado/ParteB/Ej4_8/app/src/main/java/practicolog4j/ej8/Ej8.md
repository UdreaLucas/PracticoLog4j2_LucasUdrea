# Respuestas Ej8

## En el caso del patrón A "a. %d [%-6p] %c{1} - %m%n"

_Tendremos esta salida en la consola_

```console
2022-03-01 12:34:56 [INFO  ] Ej7 - Este es un mensaje de info del ej 8
```

### Esta sería una explicación de cada una de las partes del patrón

_%d: Fecha y hora del evento de registro._

_[%-6p]: Nivel de prioridad del evento de registro, alineado a la izquierda y con un ancho mínimo de 6._

_%c{1}: Nombre de la clase que registra el evento, solo se muestra la última parte del nombre de la clase._

_%m: Mensaje del evento de registro._

_%n: Nueva línea._

## En el caso del patrón B "%sn %d{yyyy/MM/dd HH:mm:ss,SSS} %r [%-6p] [%t] %c{3} %C{3}.%M(%F:%L) - %m%n"

_Tendremos esta salida en la consola_

```console
1 2022/03/01 12:34:56,789 1234 [INFO  ] [main] practicolog4j.ej7.Ej7 practicolog4j.ej7.Ej7.main(Ej7.java:10) - Este es un mensaje de info del ej 8

```

### Esta sería una explicación de cada una de las partes del patrón

_%sn: Número de secuencia del evento de registro._

_%d{yyyy/MM/dd HH:mm:ss,SSS}: Fecha y hora del evento de registro en el formato especificado._

_%r: Tiempo transcurrido desde el inicio hasta el evento de registro._

_[%-6p]: Nivel de prioridad del evento de registro, alineado a la izquierda y con un ancho mínimo de 6._

_[%t]: Nombre del hilo de ejecución._

_%c{3}: Nombre de la clase que registra el evento, solo se muestran las últimas 3 partes del nombre de la clase._

_%C{3}.%M(%F:%L): Nombre de la clase, método, archivo y línea de donde se registra el evento._

_%m: Mensaje del evento de registro._

_%n: Nueva línea._
