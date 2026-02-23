package utils;

import java.io.*;
import java.time.LocalDateTime;

public class LoggerCustom extends Exception{
    public LoggerCustom(String mensaje) {
        super(mensaje);
    }
}
