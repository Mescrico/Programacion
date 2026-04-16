# ♨ Práctica 8 Iteradores y BBDD ♨
![Status](https://img.shields.io/badge/STATUS-DONE-white)
![Language](https://img.shields.io/badge/LANGUAGE-JAVA-red)

Esta práctica contiene los ejercicios de la practica Iteradores y BBDD

## ESTRUCTURA DEL PROYECTO

- ### [Paquete dao](src/rpg/dao)
  Contiene las clases encargadas del acceso a datos (Data Access Object).
    - #### [CiudadesDAO](src/rpg/dao/CiudadesDAO.java)
    - #### [ClasesrpgDAO](src/rpg/dao/ClasesrpgDAO.java)
    - #### [HabilidadesDAO](src/rpg/dao/HabilidadesDAO.java)
    - #### [ItemDAO](src/rpg/dao/ItemDAO.java)
    - #### [PersonajeDAO](src/rpg/dao/PersonajeDAO.java)
    - #### [RazasDAO](src/rpg/dao/RazasDAO.java)

- ### [Paquete exception](src/rpg/exception)
  Contiene las excepciones personalizadas para controlar la lógica del juego.
    - #### [FondosInsuficientesException](src/rpg/exception/FondosInsuficientesException.java)
    - #### [LimiteHabilidadesException](src/rpg/exception/LimiteHabilidadesException.java)
    - #### [NivelInsuficienteException](src/rpg/exception/NivelInsuficienteException.java)

- ### [Paquete logic](src/rpg/logic)
  Contiene la lógica de negocio y motores principales del juego.
    - #### [GestionMundo](src/rpg/logic/GestionMundo.java)
    - #### [MotorCombate](src/rpg/logic/MotorCombate.java)

- ### [Paquete model](src/rpg/model)
  Contiene las clases modelo (entidades) del proyecto.
    - #### [Ciudades](src/rpg/model/Ciudades.java)
    - #### [Clases_RPG](src/rpg/model/Clases_RPG.java)
    - #### [Habilidades](src/rpg/model/Habilidades.java)
    - #### [Items](src/rpg/model/Items.java)
    - #### [PersonajeHabilidad](src/rpg/model/PersonajeHabilidad.java)
    - #### [Personajes](src/rpg/model/Personajes.java)
    - #### [Razas](src/rpg/model/Razas.java)

- ### [Paquete ui](src/rpg/ui)
  Contiene las clases encargadas de la interfaz de usuario por consola.
    - #### [Menu](src/rpg/ui/Menu.java)

- ### [Paquete utils](src/rpg/utils)
  Contiene clases de utilidad general.
    - #### [LoggerCustom](src/rpg/utils/LoggerCustom.java)

- ### [Clase Principal](src/rpg)
    - #### [Main](src/Main.java)

---

## Ficheros de Datos y Logs
*(Archivos generados o consumidos por la aplicación)*


- ### [info.log](Ficheros/info.log)
- ### [errores.log](Ficheros/errores.log)
