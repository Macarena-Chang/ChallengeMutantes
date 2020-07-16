# ChallengeMutantes📖
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.

Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano
es mutante basándose en su secuencia de ADN.

Para eso te ha pedido crear un programa con un método o función con la siguiente
firma (En alguno de los siguiente lenguajes: Java / Golang / C-C++ / Javascript
(node) / Python / Ruby):

```
 boolean isMutant(String[] dna); //ejemplo Java
```
En donde **recibirás como parámetro un array de Strings que representan cada fila
de una tabla de (NxN)** con la secuencia del ADN. Las letras de los Strings solo
pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN.

**Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro
letras iguales, de forma oblicua, horizontal o vertical.** Ejemplo (Caso mutante):
```
String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
```
En este caso el llamado a la función isMutant(dna) devuelve “true”. Desarrolla el
algoritmo de la manera más eficiente posible. Desafíos:

 
**##Nivel 1: 📌**

Programa (en cualquier lenguaje de programación) que cumpla con el método
pedido por Magneto.
