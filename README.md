# Parcial2024BE2
Prueba Final Back End II 2024


Implementacion circuit breaker:

El _circuit breaker_ implementado en el servicio Catalog para la conexion con el microservicio Movie tiene la finalidad de evitar fallas en cascada al detectar anomalias en el comportamiento del servicio. Si las fallas alcanzan cierto umbral el estado canbia a _open_ y las llamadas posteriores a la operación se detienen automáticamente durante un período predefinido hasta que se vuelva a cerrar. Tambien se implementa un _fallback_ como plan B frente al fallo repetido de la logica primaria.

El _retry_ por otro lado, reintenta automaticamente las llamadas fallida una cantidad determinada de veces (customizable).

Este tipo de herramienta es particularmente util como alternativa a la caida de un producto, no solo para evitar fallas masivas, sino tambien ofrece la posibilidad de personalizar la interfaz del error/desconexion para una mejor experiencia de usuario.


En este caso particular la idea de colocar el  _circuit breaker_ en el servicio Catalog es la de, frente a la posible caida del servicio de Music y con una tolerancia del 50% de fallos en 5 intentos de conexion entre los servicios, insertar una alternativa visual al mensaje de error ofrecido por defecto a nivel interfaz de usuario y continuar con los intentos de reconexion con cooldowns especificados.
