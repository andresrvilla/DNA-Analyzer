![DNA- Analyzer](http://www.andres-villa.com.ar/dna-analyzer.png)
API REST para detectar secuencias de ADN

## ¿Qué es ésto?

Este proyecto tiene como objetivo evaluar conocimientos de Roberto A. Villa por parte del equipo de recruiting de MercadoLibre

## Introducción

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men. Con dicho objetivo se ha desarrollado una API REST para detectar secuencias de ADN dentro de un ADN dado. Dicha API recibe como parámetro un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

#### Ejemplos de ADN

![Ejemplos ADN](http://www.andres-villa.com.ar/dna-examples.png)

Un humano es mutante si encuentras más de una secuencia de cuatro letras iguales​, de forma oblicua, horizontal o vertical.

## Status del Proyecto

Nivel 2 completado: API REST con el objetivo de detectar ADN mutante deployada en Amazon AWS

## Instrucciones para su prueba

El servicio se encuentra deployado en [http://dna-analyzer.us-east-2.elasticbeanstalk.com/](http://dna-analyzer.us-east-2.elasticbeanstalk.com/)

El servicio actualmente cuenta con un único método POST para detectar si un ADN dado es mutante. la URL del método es [http://dna-analyzer.us-east-2.elasticbeanstalk.com/mutant](http://dna-analyzer.us-east-2.elasticbeanstalk.com/mutant)

Se puede detectar si un humano es mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el siguiente formato:

POST → /mutant/<br />
{<br />
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]<br />
}

En caso de verificar que el ADN enviado es mutante, el método devuelve como respuesta un HTTP 200-OK, en caso contrario un
403-Forbidden 

Se puede probar utilizando [Postman](https://www.getpostman.com/). Puede importar el proyecto desde [El siguiente vínculo](https://www.getpostman.com/collections/717c334070e97e8dbbf9)

## Environment

* [Java8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html)
* IDE: [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [Maven](https://maven.apache.org/)
* [Jersey](https://jersey.github.io/)
* [Junit 5](https://junit.org/junit5/)


## Atribuciones de terceros
* [Vector de Fondo creado por ikatod](https://www.freepik.es/vector-gratis/vector-de-red-de-fondo-triangulo-de-poligono-abstracto_1306336.htm)
* Icons made by [Freepik](http://www.freepik.com) from [Flaticon](https://www.flaticon.com/)