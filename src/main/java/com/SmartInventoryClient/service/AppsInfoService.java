package com.SmartInventoryClient.service;

import com.SmartInventoryClient.command.Command;
import com.SmartInventoryClient.model.Software;
import com.SmartInventoryClient.service.DTO.AppsDTO;
import com.SmartInventoryClient.util.BeanUtilReflection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppsInfoService {

    @Autowired
    private BeanUtilReflection beanUtilsReflection;

    @Value("${password}")
    private String pass;


    public List<Software> getListApps(){
        try{
            String test = pass;
            List<String> ls1 = Command.runFromRoot("sudo ls /usr/share/applications/", pass.trim());
            List<String> ls2 = (Command.runFromRoot("sudo ls /var/lib/snapd/desktop/applications/",pass.trim()));

            List<AppsDTO> apps = new ArrayList<>();
            ls1.sort(String::compareTo);
            for( String s:ls1){
                List<String> returnCommand  = Command
                        .runFromRoot( "sudo cat /usr/share/applications/"
                                .concat(s.trim()),pass.trim());
                AppsDTO app = (AppsDTO)beanUtilsReflection.returnBean(returnCommand,AppsDTO.class,"=");
                apps.add(app);
            }

            for( String s:ls2){
                List<String> returnCommand  = Command
                        .runFromRoot( "sudo cat /var/lib/snapd/desktop/applications/"
                                .concat(s.trim()),pass.trim());
                AppsDTO app = (AppsDTO)beanUtilsReflection.returnBean(returnCommand,AppsDTO.class,"=");
                apps.add(app);
            }


            System.out.println("Lista de comandos (qtd):"+apps.size());
            return convert(apps);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    private List<Software> convert(List<AppsDTO> appsDTO){
        List<Software> softwares = new ArrayList<>();
        for (AppsDTO apps : appsDTO){
            Software software = new Software();
            software.setCategories(apps.getCategories());
            software.setName(apps.getName());
            software.setVersion(apps.getVersion());
            software.setCategories(apps.getCategories());
            software.setInstallLocation(apps.getExec());
            softwares.add(software);
        }
        return softwares;
    }

}
