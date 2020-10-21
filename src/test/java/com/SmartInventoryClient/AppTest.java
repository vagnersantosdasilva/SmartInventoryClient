package com.SmartInventoryClient;

import com.SmartInventoryClient.service.DTO.AppsDTO;
import com.SmartInventoryClient.service.ExtractAppsInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    @Autowired
    private ExtractAppsInfoService extractAppsInfoService ;

    @Test
    public void testApps() throws IOException {
      List<AppsDTO> apps = extractAppsInfoService.getListApps();
      if (apps!=null){
          for(AppsDTO app : apps) {
              if (app.getName() != null) {
                  System.out.println("Name :" + app.getName());
                  System.out.println("Comments :" + app.getComment());
                  System.out.println("Categories :" + app.getCategories());
                  System.out.println("Version :" + app.getVersion());
                  System.out.println("Exec :" + app.getExec());
                  System.out.println("");
              }
          }
      }

    }
}
