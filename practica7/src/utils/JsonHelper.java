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

    public <T> List<T> readList(String path, Class<T> clazz) {
        try(Reader reader =  new FileReader(path)) {

            Gson gson = new Gson();
            Type TypeOfT = TypeToken.getParameterized(List.class, clazz).getType();
            LoggerCustom.log("["+ LocalDateTime.now()+"] INFO: Se ha leído el archivo "+path);

            return gson.fromJson(reader, TypeOfT);
        } catch (Exception e) {
            LoggerCustom.log("["+ LocalDateTime.now()+"] ERROR: "+e.getClass().getSimpleName()+" - "+e.getMessage());
            return List.of();
        }
    }

    public <T> void writeList(String path, List<T> lista)  {
        try(Writer writer = new FileWriter(path)) {
            Gson gson = new Gson();
            gson.toJson(lista, writer);
            LoggerCustom.log("["+ LocalDateTime.now()+"] INFO: Se ha escrito el archivo "+path);

        } catch (IOException e) {
            LoggerCustom.log("["+ LocalDateTime.now()+"] ERROR: "+e.getClass().getSimpleName()+" - "+e.getMessage());
        }
    }
}
