package com.SmartInventoryClient;

import com.SmartInventoryClient.model.Software;
import com.SmartInventoryClient.service.AppsInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppsInfoServiceTest {

    @Autowired
    private AppsInfoService extractAppsInfoService ;

    @Test
    public void testApps() throws IOException {
      List<Software> apps = extractAppsInfoService.getListApps();
      if (apps!=null){
          for(Software app : apps) {
              if (app.getName() != null) {
                  System.out.println("Name :" + app.getName());
                  System.out.println("Comments :" + "");
                  System.out.println("Categories :" + app.getCategories());
                  System.out.println("Version :" + app.getVersion());
                  System.out.println("Exec :" + app.getInstallLocation());
                  System.out.println("");
              }
          }
      }

    }
}
