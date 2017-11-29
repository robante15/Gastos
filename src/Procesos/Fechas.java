/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author roban
 */
public class Fechas {
    
   public void EstaSemana(){
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
        c.add(Calendar.DATE, -i);
        Date start = c.getTime();
        c.add(Calendar.DATE, 6);
        Date end = c.getTime();
        
        String inicio = df.format(start);
        String finSemana = df.format(end);
        
        System.out.println(start + " - " + end);
        System.out.println(inicio + " - " + finSemana);
    }
}

