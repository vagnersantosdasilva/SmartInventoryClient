package com.SmartInventoryClient.util;

import com.SmartInventoryClient.service.MachineDTO;
import com.google.gson.Gson;

import java.io.*;

public class FileUtil {

    /*To do   Exceções não foram tratadas */
    public static boolean fileJSONWriter(String remoteMachine) {
        return true;
    }

    public static MachineDTO fileJSONRead(String currentMachine)  {


        Gson gson = new Gson();
        String file = copyFile(currentMachine);

        MachineDTO machineDTO = gson.fromJson(file,MachineDTO.class);

        return machineDTO;
    }

    private static String copyFile(String pathFile){

        StringBuilder sb = new StringBuilder();
        try {
            Reader r = new FileReader(pathFile);
            BufferedReader br = new BufferedReader(r);
            String linha;


            while((linha=br.readLine())!=null)
            {
                sb.append(linha);


            }
            br.close();
            r.close();

            return sb.toString();
        }
        catch(IOException e)
        {
            System.out.println("Erro no processamento do arquivo : "+pathFile );
            System.out.println(e.getMessage());
        }

        return null;
    }


}
