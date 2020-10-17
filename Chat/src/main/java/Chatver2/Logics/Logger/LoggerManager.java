
package Chatver2.Logics.Logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony Chaves and Christopher Castro
 * Gives a global logger manager that is configurable
 */
public class LoggerManager {
    /**
     * Gets the default logger
     * @return default logger
     */
    public static Logger getBitacora(){
        return Logger.getGlobal();
    }
    /**
     * Configures a custom logger
     * @param pkg package where the logger will be operating
     * @param file file where logs will be written
     * @param lvl Level that will be allowed
     * @return the configured logger
     */
    public static Logger getBitacora(String pkg, String file, Level lvl){
       Logger bitacora = null;
       bitacora = Logger.getLogger(pkg);
       
       try{
           FileHandler handler = new FileHandler(file);
           bitacora.addHandler(handler);
       }
       catch(IOException e){
           bitacora = Logger.getGlobal();
           bitacora.severe("Error al crear la bitacora: "+ e.getMessage());
       }
       bitacora.setLevel(lvl);
       return bitacora;
    }
}
