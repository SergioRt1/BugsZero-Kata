# BugsZero Kata

### Escuela colombiana de ingeniería Julio Garavito
### CSDT
## Proyecto
* Idioma seleccionado: Kotlin

## Code smells y problemas detectados
* Código duplicado
* Código dificil de testear
* Acceso a indices de arreglos sin validar, generadon posibles index out of bounds exeption.
* Variables definidas como mutables cuando pueden ser inmutadbles y definirse en el constructor
* El constructor no se usa para inicializar los parametros de la clase, se usan los valores default
* Acoplamiento de la cantidad de jugadores
* Poca cohesión entre la logica y los datos


## Técnicas de refactor identificadas 
* Extract Method
* Extract variable
* Encapsulate Record
* Change Function Declaration
* Inline Function
* Replace Magic Literal
* Remove Flag Argument

## Autor
* **[Sergio Rodríguez](https://github.com/SergioRt1)** 
  
## License
This project is license under the Apache-2.0 License - see the [LICENSE](LICENSE) file for more details.
