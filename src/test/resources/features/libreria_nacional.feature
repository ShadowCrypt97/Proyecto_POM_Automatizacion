#Author: Sergio Andrés Gómez Roa
#language: es
@HistoriaDeUsuario
  Característica: Como usuario de la página Librería Nacional
                  Quiero crear una cuenta en la página
                  Para comprar un libro

    Antecedentes:
      Dado que me encuentro en la página web de la Librería Nacional

    @Escenario1
    Escenario: Registrar Cuenta
      Y me encuentro en la opción de registrarme
      Cuando realice el registro de mi cuenta en la página
      Entonces verifico que la cuenta haya sido creada exitosamente

    @Escenario2
    Esquema del escenario: Comprar Libro
      E ingreso con una cuenta registrada
      Cuando busco el Libro "<nombreLibro>"
      Y lo agrego al carrito de compras
      Y vea el carrito de compras
      Y agregue la cantidad de <cantidad> libros
      Y continue con la compra
      Y adicione la información para el envío
      Entonces verifico que la cantidad de libros es <cantidad>
      Y verifico el total de la compra realizada para <cantidad> libros

      Ejemplos:
      |nombreLibro                                   |cantidad|
      |Android Manual Práctico para todos los Niveles|   2    |

