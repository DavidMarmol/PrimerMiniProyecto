# PrimerMiniProyecto
Primer MiniProyecto del curso divido en dos partes, un CRUD y opciones de gestiones
monetarias.

Miembros del grupo: 
- Juan Jose Millan Hernandez 2266393
- Andres Felipe Chaparro Pulgarin 2266252
- Jose David Marmol Otero 2266370

CRUD: Se crea un menú para gestionar clientes y su informacion, con las opciones:

- Insertar cliente: Crear perfil o guardar informacion del cliente.
- Actualizar ahorro: Actualiza el ahorro disponible del cliente.
- Eliminar cliente: Se elimina la informacion del cliente.
- Buscar cliente: Se busca el cliente con su nombre.
- Listar clientes: Se listan la cantidad de clientes registrados.
- Pedir prestamo: Se solicita un prestamo y se realiza segun sus ahorros.
- CDT: Solicitar CDT.
- Salir: Se sale del menú.

Préstamos:
Si el cliente solicita una cantidad menor o igual a su ahorro disponible, se le otorga el préstamo y se actualiza su saldo. Si solicita más de lo que tiene ahorrado pero menos o igual al doble, se le concede un préstamo limitado al doble de su ahorro disponible, con un interés compuesto del 2% efectivo anual, pagado en 6 cuotas mensuales.

CDT (Certificado de Depósito a Término):
Un cliente puede solicitar un CDT por 3 o 6 meses. La tasa de interés anual varía según la duración del CDT (3% para 3 meses y 5% para 6 meses). Después de seleccionar la duración del CDT, se muestra por consola cuánto dinero ganará en total pasado el tiempo especificado, basado en su ahorro inicial.
