package com.SmartInventoryClient.service;

import com.SmartInventoryClient.command.Command;
import com.SmartInventoryClient.model.OperationalSystem;
import com.SmartInventoryClient.service.DTO.OpSystemDTO;
import com.SmartInventoryClient.util.BeanUtilReflection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OperationalSystemInfoService {

    @Value("${password}")
    private String pass;

    @Autowired
    BeanUtilReflection beanUtilReflection;

    public OperationalSystem getOperationalSystem(){
        try {
            List<String> returnCommand = Command.runFromRoot("sudo sh scripts/system.sh", pass.trim());
            OpSystemDTO dto = (OpSystemDTO) beanUtilReflection.returnBean(returnCommand, OpSystemDTO.class,"=");
            OperationalSystem op = new OperationalSystem(null,
                    null, dto.getDistributorId(),dto.getDescription(),dto.getHostname(),
                    null,dto.getRelease(),null,dto.getUpTime());
            return op;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

}
