package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import handler.RecursoNoEncontradoException;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

public class JsonHelper {
    public JsonHelper() {
    }

    //Creo el readList al que se le tiene que pasar la ruta y una clase generica
    public <T> List<T> readList(String path, Class<T> clazz) {
        //Creamos el Reader
        try(Reader reader =  new FileReader(path)) {
            //Creamos el gson
            Gson gson = new Gson();

            //Llamamos a Type y TypeToken.getParameterized().getType() para saber de que clase es la lista
            Type TypeOfT = TypeToken.getParameterized(List.class, clazz).getType();
            LoggerCustom.log("["+ LocalDateTime.now()+"] INFO: Se ha leído el archivo "+path);

            //Devolvemos una lista con la informacion del archivo
            return gson.fromJson(reader, TypeOfT);
        } catch (Exception e) {
            LoggerCustom.log("["+ LocalDateTime.now()+"] ERROR: "+e.getClass().getSimpleName()+" - "+e.getMessage());
            return List.of();
        }
    }

    //Creamos el writeList al que se le pasa la ruta y una lista generica
    public <T> void writeList(String path, List<T> lista)  {
        //Creamos el writer
        try(Writer writer = new FileWriter(path)) {
            //Creamos el gson
            Gson gson = new Gson();
            //Añadimos la lista al archivo
            gson.toJson(lista, writer);
            LoggerCustom.log("["+ LocalDateTime.now()+"] INFO: Se ha escrito el archivo "+path);

        } catch (IOException e) {
            LoggerCustom.log("["+ LocalDateTime.now()+"] ERROR: "+e.getClass().getSimpleName()+" - "+e.getMessage());
        }
    }
}
