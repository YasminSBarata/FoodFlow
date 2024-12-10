/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author mateu
 */
public class Checagem {
        public static boolean Vazio(String... vars){
        for(String s: vars){
            if (s.equals("")){
                return true;
            }
        }
        
        return false;
    }
}
