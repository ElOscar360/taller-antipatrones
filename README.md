# Taller para la Casa – La Oficina de Visas del Caos (Java 17+)

Asignatura: Modelos de Programación · Universidad Distrital Francisco José de Caldas

## Ejecutar
    ./compilar_y_ejecutar.sh
(La salida de los 5 casos está en `salida_consola.txt`.)

## Parte 1 – Cacería de antipatrones
| Fragmento | Antipatrón | Síntoma que lo delata | Consecuencia en el consulado |
|---|---|---|---|
| 1. OficinaDeTodo | God Object | Una clase valida, cobra, guarda y envía correo | Si Ramiro falla (o cambia una regla), todo el trámite se detiene; no se puede probar ni reutilizar nada por separado |
| 2. CalculadoraDeTarifas | Copy-Paste Programming | La misma fórmula `50 * meses + 10` repetida en 3 métodos | Al subir la tarifa se corrigieron 2 de 3 y una visa quedó con el precio viejo |
| 3. EvaluadorMagico | Magic Numbers | `tipo == 3`, `edad > 17`, `< 66`, `0.5` sin nombre | Nadie sabe qué significan; un tipo inexistente (9) se rechaza en silencio y los cambios de regla son riesgosos |
| 4. SolicitudAcoplada | Acoplamiento fuerte | La solicitud hace `new` de cada servicio y los llama uno por uno | Se olvidó `pagos` y a un viajero se le perdió el reembolso; agregar un aviso obliga a editar la solicitud |

## Cómo la solución evita caer de nuevo en los antipatrones
Cada clase tiene una sola razón para cambiar: validar, cobrar, guardar y notificar viven separados y `TramitadorDeVisa` solo orquesta, así que no nace un nuevo Ramiro. La fórmula de precio existe una sola vez en `TarifaBase`; cada visa es una estrategia que solo aporta su factor, de modo que subir la tarifa es un cambio y un tipo nuevo es una clase nueva. Los números y textos tienen nombre (`TipoVisa`, `LimitesEdad`, `ConstantesTarifa`, `Mensajes`) y un tipo inválido produce un mensaje claro. Finalmente, `Solicitud` solo conoce la interfaz `ObservadorDeSolicitud`: agregar un aviso nuevo es crear un observador y suscribirlo, sin tocar código ajeno ni poder "olvidar" a nadie.

# Capturas
<img width="761" height="317" alt="image" src="https://github.com/user-attachments/assets/54660311-4500-40c7-a4e6-eceec6dba26b" />
<img width="755" height="213" alt="image" src="https://github.com/user-attachments/assets/b2ae78d6-27af-47de-bbcf-b3167396c45e" />
<img width="1167" height="187" alt="image" src="https://github.com/user-attachments/assets/191d07fb-4e55-4033-9657-3b89bdb04cd8" />
<img width="836" height="282" alt="image" src="https://github.com/user-attachments/assets/368941e8-81bc-4dc9-91df-ed87bfcf4b3c" />
<img width="765" height="330" alt="image" src="https://github.com/user-attachments/assets/5a9893f6-cff6-4a20-b539-1060599f6c5e" />
<img width="1278" height="190" alt="image" src="https://github.com/user-attachments/assets/cc607729-888e-4462-95dd-6c811b9c0aee" />



