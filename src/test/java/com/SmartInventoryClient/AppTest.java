package com.SmartInventoryClient;

import com.SmartInventoryClient.service.DTO.AppsDTO;
import com.SmartInventoryClient.service.ExtractAppsInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class AppTest {

   private ExtractAppsInfoService extractAppsInfoService = new ExtractAppsInfoService();


    @Test
    public void testApps() throws IOException {
      List<AppsDTO> apps = extractAppsInfoService.getListApps();
        for(AppsDTO app : apps){
            if (app.getName()!=null){
                System.out.println("Name :"+app.getName());
                System.out.println("Comments :"+app.getComment());
                System.out.println("Categories :"+app.getCategories());
                System.out.println("Version :"+app.getVersion());
                System.out.println("Exec :"+app.getExec());
                System.out.println("");
            }
        }
    }
}
