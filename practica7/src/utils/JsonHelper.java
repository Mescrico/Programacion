package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class JsonHelper {
    public JsonHelper() {
    }

    public <T> List<T> readList(String path, Class<T> clazz) {
        try(Reader reader =  new FileReader(path)) {
            Gson gson = new Gson();
            Type TypeOfT = TypeToken.getParameterized(List.class, clazz).getType();

            return gson.fromJson(reader, TypeOfT);
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
            return List.of();
        }
    }

    public <T> void writeList(String path, List<T> lista)  {
        try(Writer writer = new FileWriter(path)) {
            Gson gson = new Gson();
            gson.toJson(lista, writer);
        } catch (Exception e) {
            System.out.println("No se ha podido sobreescribir por "+e.getMessage());
        }
    }
}
