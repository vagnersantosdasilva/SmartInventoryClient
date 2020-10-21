package com.SmartInventoryClient.service;

import com.SmartInventoryClient.command.Command;
import com.SmartInventoryClient.service.DTO.AppsDTO;
import com.SmartInventoryClient.util.BeanUtilReflection;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExtractAppsInfoService {

    /* A saida de cada .desktop não é uniforme
    * é preciso iterar em cada arquivo e montar uma lista intermediária
    */
    BeanUtilReflection beanUtilsReflection = new BeanUtilReflection();

    public List<AppsDTO> getListApps(){
        try{
            List<String> ls = Command.runFromRoot("sudo ls /usr/share/applications/", "#F1a2c5h4_nvl");
            System.out.println("Primeira lista de arquivos QTD:"+ls.size());
            List<AppsDTO> apps = new ArrayList<>();
            ls.sort(String::compareTo);
            for( String s:ls){
                List<String> returnCommand  = Command
                        .runFromRoot( "sudo cat /usr/share/applications/"
                                .concat(s.trim()),"#F1a2c5h4_nvl");
                AppsDTO app = (AppsDTO)beanUtilsReflection.returnBean(returnCommand,AppsDTO.class,"=");
                apps.add(app);
            }
            System.out.println("Lista de comandos (qtd):"+apps.size());
            return apps;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
