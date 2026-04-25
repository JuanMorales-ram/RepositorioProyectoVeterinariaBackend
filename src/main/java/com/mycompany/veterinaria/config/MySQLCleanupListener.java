/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.config;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MySQLCleanupListener implements ServletContextListener {
    
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        try{
            AbandonedConnectionCleanupThread.checkedShutdown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
