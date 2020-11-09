package com.SmartInventoryClient.util;

import com.SmartInventoryClient.service.DTO.MachineDTO;
import com.google.gson.Gson;

import java.io.*;

public class FileUtil {

    /*To do   Exceções não foram tratadas */
    private static Gson gson = new Gson();

    public static boolean fileJSONWriter(MachineDTO machineDTO,String path) {
        if (machineDTO == null) return false;
        String json = gson.toJson(machineDTO);
        if (saveJsonInFile(json,path)) return true;
        return false;
    }

    private static boolean saveJsonInFile(String json,String path){
        try{
            Writer w = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(w);
            bw.write(json);
            bw.close();
            w.close();
            return true;
        }catch (IOException e){
            System.out.println("Erro ao tentar gravar Json : [FileUtil:saveJsonInFile]");
            e.printStackTrace();
        }

        return false;
    }

    public static MachineDTO fileJSONRead(String pathFile)  {

        String file = copyFile(pathFile);
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
            System.out.println("Erro ao tentar ler Json : [FileUtil:copyFile]");
            e.printStackTrace();
        }
        return null;
    }

}
