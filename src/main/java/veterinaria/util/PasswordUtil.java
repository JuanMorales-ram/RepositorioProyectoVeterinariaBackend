/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria.util;

import org.mindrot.jbcrypt.BCrypt;


public class PasswordUtil {
    
    public static String cifrar (String passwordPlano){
        return BCrypt.hashpw(passwordPlano, BCrypt.gensalt());
    }
    
    public static boolean verificar (String passwordPlano, String hash){
        return BCrypt.checkpw(passwordPlano, hash);
    }
    
}
