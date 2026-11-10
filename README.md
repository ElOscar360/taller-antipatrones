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