package com.SmartInventoryClient.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Command {

    public static List<String> runFromRoot(String command, String password) throws IOException {
        byte[] passwd = (password+"\n").getBytes(); //for OutputStream better is byte[]
        Process p = Runtime.getRuntime().exec(new String[]{"sh","-c","sudo -S "+command});
        p.getOutputStream().write(passwd);
        p.getOutputStream().flush();
        InputStream ip = p.getInputStream();
        BufferedReader br = new BufferedReader (new InputStreamReader(ip));
        String line;
        List<String> list = new ArrayList();
        while ((line=br.readLine())!=null) {list.add(line);}
        return list;
    }
}
