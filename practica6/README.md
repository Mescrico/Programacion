# ♨ Práctica 6 Java ♨  

![Status](https://img.shields.io/badge/STATUS-DONE-white)
![Language](https://img.shields.io/badge/LANGUAGE-JAVA-red)

Esta práctica contiene los ejercicios de Estructura de Datos POO II

## BLOQUE 1: Operaciones Básicas

- ### [Ejercicio 1: El Registro de Muertes](src/ejercicio1.java) 
    1. Crea un ArrayList llamado registroCombate. Añade 5
       eventos (ej: "Orco derrotado", "Poción usada"). Luego, muestra el tercer evento que
       ocurrió.

- ### [Ejercicio 2: El Censo Único](src/ejercicio2.java)
    1. Crea un HashSet de nombres de villanos. Intenta añadir a
       "Morgoth" dos veces. Al final, imprime el tamaño del Set para demostrar que no se
       duplicó
- ### [Ejercicio 3: Bolsa de Oro](src/ejercicio3.java)
    1. Crea un HashMap<String, Integer> donde la clave sea el nombre
       del aventurero y el valor su cantidad de oro. Añade a 3 héroes y muestra el oro de
       uno de ellos usando su nombre
- ### [Ejercicio 4: Limpieza del Calabozo](src/ejercicio4.java)
    1. Usando el ArrayList del ejercicio 1, elimina el evento más
       antiguo (índice 0) y añade uno nuevo al final ("Dragón avistado")
- ### [Ejercicio 5: Mercado de Hechizos](src/ejercicio5.java)
    1. Crea un HashMap<String, Double> con nombres de
       hechizos y sus costos de maná. Usa un bucle para imprimir todos los hechizos que
       cuesten más de 50 de maná
- ### [Ejercicio 6: Expulsión del Reino](src/ejercicio6.java)
    1. En tu HashSet de villanos, verifica si "Sauron" está presente. Si
       está, elimínalo porque ha sido derrotado

## BLOQUE 2: Desafíos de Lógica Anidada

- ### [Ejercicio 7: El Repositorio de Gremios](src/ejercicio7.java)
    1. Crea un HashMap<String, ArrayList<String>>. La
       clave es el nombre del gremio (ej: "Magos") y el valor es una lista de sus
       miembros. Agrega 2 gremios con 3 miembros cada uno y programa una función que
       imprima solo los miembros de un gremio específico
- ### [Ejercicio 8: El Sistema de Loot (Botín)](src/ejercicio8.java)
    1. Crea un HashMap<String, HashSet<String>>
       donde cada Monstruo tiene un set de Objetos que puede soltar
    2. Reto: Si el "Trasgo" suelta una "Espada Oxidada" y tú intentas añadirle otra
       "Espada Oxidada" por error, el sistema debe ignorarlo automáticamente
- ### [Ejercicio 9: El Repositorio de Gremios](src/ejercicio9.java)
    1. Crea un HashMap<String, HashMap<String, Integer>>
    2. La clave principal es el Nombre del Jugador 
    3. El valor es OTRO HashMap que contiene sus estadísticas (ej: {"Fuerza":
       18, "Destreza": 12})
    4. Reto: Escribe el código para buscar a "Conan" y sumarle +2 a su estadística de
       "Fuerza"
- ### [Ejercicio 10: El Repositorio de Gremios](src/ejercicio10.java)
    1. Tienes un HashMap<String, ArrayList<String>> de
       Gremios (como en el ej. 7). Escribe un algoritmo que recorra todos los gremios y
       verifique si un aventurero llamado "Judas" está escondido en alguno de ellos. Si lo
       encuentra, debe imprimir en qué gremio está y eliminarlo de la lista de ese gremio
       inmediatamente

## BLOQUE 3: Desafíos

- ### [Ejercicio 11: El Sistema de Comercio y Precios Dinámicos](src/ejercicio11.java)
    1. Crea un HashMap<String,
       Double> con los precios base de varios items. Luego, crea un HashMap<String,
       ArrayList<String>> que represente las Ciudades y los Items en Stock que
       tienen
    2. El Reto: Escribe un método que reciba el nombre de una ciudad. Si la ciudad
       tiene más de 5 items en stock, aplica un "impuesto de lujo" aumentando un
       10% el precio de sus items en el mapa de precios base solo para esa
       transacción
- ### [Ejercicio 12: Gestión de Árboles de Habilidades (Nested Maps)](src/ejercicio12.java)
    1. Crea una estructura
       HashMap<String, HashMap<String, Boolean>>. La primera clave es el Nombre
       de la Clase (ej: "Paladín"). El segundo Map contiene las Habilidades y un booleano
       que indica si están Bloqueadas o Desbloqueadas
    2. El Reto: Crea una función que, al desbloquear la habilidad "Golpe Divino",
       verifique automáticamente si el jugador tiene desbloqueada la habilidad
       "Enfoque" (del mismo mapa). Si no la tiene, no puede desbloquear "Golpe
       Divino" y debe lanzar un mensaje de error
- ### [Ejercicio 13: El Historial de Incursiones (Raid Tracker)](src/ejercicio13.java)
    1. Usa un HashMap<String, List<HashSet<String>>>. La clave es el Nombre de la Mazmorra. El valor es una
       Lista de todas las veces que se ha completado (Raids). Cada entrada en la lista es un
       HashSet con los nombres de los jugadores que participaron (para evitar que el
       mismo jugador cuente dos veces en la misma incursión)
    2. El Reto: Escribe un algoritmo que recorra todo el historial y encuentre al
       "Jugador Más Valioso" (el nombre que más veces aparece en todas las
       incursiones de todas las mazmorras)
- ### [Ejercicio 14: El Sistema de Mensajería Global (Filtro de Spam)](src/ejercicio14.java)
    1. Crea un HashMap<String, List<String>> que almacene los mensajes enviados por cada jugador
    2. El Reto: Crea un sistema que analice los últimos 3 mensajes de cada jugador
       (en su ArrayList). Si un jugador tiene 2 mensajes idénticos dentro de sus últimos 3, añade su nombre a un HashSet<String> llamado
       jugadoresSilenciados y limpia su historial de mensajes
- ### [Ejercicio 15: Simulador de Economía de Subastas (Auction House)](src/ejercicio15.java) y [Ejercicio 15: Clase Puja](src/Puja.java)
    1. Imagina una estructura HashMap<String, PriorityQueue<Double>> (o usa un ArrayList y ordénalo).
       La clave es el Nombre del Item (ej: "Excalibur") y el valor es una lista de las Pujas
       actuales (números decimales)
    2. El Reto: Escribe un método procesarVenta que:
        1. Tome el item con la puja más alta
        2. Verifique en un HashMap<String, Double> de Saldos de
           Jugadores si el mejor postor tiene suficiente oro
        3. Si tiene éxito, transfiere el oro y elimina el item del mercado. Si no,
           elimina esa puja y pasa a la siguiente más alta

