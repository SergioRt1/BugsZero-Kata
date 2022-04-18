# BugsZero Kata

### Escuela colombiana de ingeniería Julio Garavito

### CSDT

## Proyecto

* Idioma seleccionado: **Kotlin**

### **Temas:**

* [Revisión preliminar](CSDT_PrimeraEntrega2022.md)
* [Análisis del código](CSDT_PrimeraEntrega2022.md)
* [Análisis deuda técnica en las Pruebas](CSDT_PrimeraEntrega2022.md)
* [CI y herramientas de análisis de calidad](CI-GitHub.md)
* [Deuda en la arquitectura](CSDT_Architectural_debt.md)
* [ATAM + QAW](CSDT_ATAM+QAW.md)

---

## Análisis de atributos de calidad en la arquitectura

Al momento de plantarnos una arquitectura compleja es necesario analizar los atributos de calidad del sistema y
priorizarlos, debido a que nos encontraremos con escenarios en los que debemos realizar concesiones entre estos
atributos para priorizar algunos sobre otros. A continuación plantearemos dos escenarios qué buscan poner a prueba
nuestras decisiones de arquitectura para validar si se cumple la prioridad que le dimos a los atributos de calidad y
plantearnos posibles mejoras o modificaciones a la arquitectura qué nos permitan satisfacer los escenarios planteados.

### Refinamiento de escenarios

Debido al reducido el tamaño del proyecto sobre el cual se está realizando el análisis, se plantearon los escenarios
pensando en cuáles son los atributos de calidad qué son se peden ver afectados por el artefacto del que disponemos (el
código fuente) y serian relevantes para el owner del producto.

|  | **Scenario Refinement for Scenario 1**                                                                                                                     |
|----------------------------------------|----------------------------------------------------------------------------------------------------------------------|
| **Scenario(s):**                       | Cuándo se decide agregar la capacidad al juego para poder jugar con un número arbitrario de jugadores                |
| **Business Goals:**                    | Nueva característica                                                                                                 |
| **Relevant Quality Attributes:**       | Modificabilidad                                                                                                      |
| **Stimulus:**                          | Se determinó que los usuarios del producto desean a jugar con más de 6 jugadores                                     |
| **Stimulus Source:**                   | Feedback provisto por los usuarios a través de encuestas, valoraciones en linea o sugerencias                        |
| **Environment:**                       | El producto es exitoso y se detecta la necesidad de nuevas características                                           |
| **Artifact (If Known):**               | Código fuente                                                                                                        |
| **Response:**                          | Es posible jugar con cualquier número de jugadores                                                                   |
| **Response Measure:**                  | Tiempo qué se demora en salir el feature a producción y esfuerzo medido en puntos de historia para realizar la tarea |
| **Questions:**                         | Cuánto esfuerzo nos costaría desarrollar esta característica                                                         |
| **Issues:**                            | Puede ser necesario refactorizar y realizar modificaciones en el código para poder tener esta característica         |

Este primer escenario planteó porque se detectó en el código que había cierto acoplamiento que impedía la 
modificabilidad de la cantidad de jugadores que pueden jugar el juego.

|  | **Scenario Refinement for Scenario 2**                                                                                                                               |
|----------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Scenario(s):**                       | Se desea expandir el mercado del juego haciéndolo disponible en múltiples plataformas con diferentes sistemas operativos                                             |
| **Business Goals:**                    | Expansión del producto                                                                                                                                               |
| **Relevant Quality Attributes:**       | Portabilidad                                                                                                                                                         |
| **Stimulus:**                          | El producto es exitoso y se desea expandir a nuevas plataformas                                                                                                      |
| **Stimulus Source:**                   | Estadísticas de consumo del producto                                                                                                                                 |
| **Environment:**                       | El producto está rindiendo satisfactoriamente en la plataforma actual                                                                                                |
| **Artifact (If Known):**               | Código fuente                                                                                                                                                        |
| **Response:**                          | El producto funciona sin problemas en todas las plataformas deseadas                                                                                                 |
| **Response Measure:**                  | Número de plataformas en las que función correctamente                                                                                                               |
| **Questions:**                         | Cuál sería el número mínimo adecuado de plataformas en las que debería funcionar el producto y cuales serían las plataformas a las que se desea expandir el producto |
| **Issues:**                            | Durante el desarrollo del componente de software es necesario garantizar la portabilidad del sistema                                                                 |

El segundo escenario se planteó porque identificó que se importa una librería de
pruebas ([ApprovalTests](kotlin/src/main/lib/ApprovalTests.jar)) de forma inadecuada lo cual afecta significativamente
la portabilidad del sistema.

## Autor

* **[Sergio Rodríguez](https://github.com/SergioRt1)**

## License

This project is license under the Apache-2.0 License - see the [LICENSE](LICENSE) file for more details.
