# BugsZero Kata

### Escuela colombiana de ingeniería Julio Garavito
### CSDT

---
## Proyecto
* Idioma seleccionado: **Kotlin**
---
## Prácticas de Testing debt
* **Son pruebas unitarias no de integración:** No se implementan pruebas unitarias, hay una sola prueba en el proyecto y válida toda la funcionalidad en diversos casos,
  se podrían considerar pruebas de usuario final.
* Las pruebas están muy acopladas al estado actual del proyecto, si se agregan nuevas funcionalidades se debera cambiar
  el archivo [GameTest.itsLockedDown.approved.txt](/kotlin/src/test/kotlin/com/adaptionsoft/games/trivia/GameTest.itsLockedDown.approved.txt)
  que contiene todos los escenarios que son válidos.
* Promover un cubrimiento alto: Las pruebas se cubre casi todo el código (96% líneas), el único método que no se prueba es:
  ```kotlin
    val isPlayable: Boolean
        get() = howManyPlayers() >= 2
  ```
   porque es un método que no se usa, aun así se podría realizar una prueba unitaria para validar su funcionamiento.
* No se usa el patrón AAA
* No se cumple _Divide y vencerás. Foco en un escenario a la vez_ se corre un único [test](/kotlin/src/test/kotlin/com/adaptionsoft/games/trivia/GameTest.kt) que cubre varios escenarios.
* **Utilice estándares de nombramiento y prácticas de Clean Code:** El nombre del test no es `itsLockedDown` muy semántico 
  de lo que se desea validar.
* **Nuevos defectos nuevas pruebas unitarias**: Como está si se detecta un defecto se modificaría el archivo [GameTest.itsLockedDown.approved.txt](/kotlin/src/test/kotlin/com/adaptionsoft/games/trivia/GameTest.itsLockedDown.approved.txt)
  que contiene los resultados esperados, no se realizaría una nueva prueba unitaria.
## Pruebas unitarias
Se Agregaron nuevas pruebas unitarias para la clase `Game` en el archivo [GameTest.kt](/kotlin/src/test/kotlin/com/adaptionsoft/games/ugltrivia/GameTest.kt) que se encuentra en el mismo paquete de la clase aprobar
y se renombró el test original a [GameRunnerTest](/kotlin/src/test/kotlin/com/adaptionsoft/games/trivia/GameRunnerTest.kt)

Para garantizar que no hayan dependencias entre pruebas se agregaron bloques `@Before` y `@After` para limpiar la ejecución de cada caso
 ```kotlin
    private lateinit var out: PrintStream

    @Before
    fun setUp() {
        out = System.out
    }

    @After
    fun tearDown() {
        System.setOut(out)
    }
```
Cada test tiene el buffer de salida default, por lo que si se valida el output sobreescribiendo el buffer 
no va a afectar a otras pruebas, esto es util para pruebas como `roll message should work` y `add player message should work` 
entre otras que validan el output de la consola.

## Sugerencias
* Se debería refactorizar el código para reducir las dependencias entre métodos, por ejemplo hay métodos que realizan multiples 
  acciones y llaman a otros métodos privados que son difíciles de probar de forma individual,
  como `roll` llama `movePlayerAndAskQuestion` que a su ves llama a `askQuestion` que llama a `currentCategory`.
* Separar la capa de UI y de lógica, se deben hacer pruebas que cubran ambas funcionalidades sobre el mismo método, por ejemplo
  las pruebas `add player message should work` y `add player should work`, este acoplamiento dificulta las pruebas y la extensibilidad de la aplicación.

---
## Autor
* **[Sergio Rodríguez](https://github.com/SergioRt1)** 