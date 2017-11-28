package com.example.pchan.mysqldemo;

import android.content.Context;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Taylor on 11/27/2017.
 */

public class aFileIO {
List<AlarmInt> alrmList;


    public aFileIO(File alrmDat){
        this.alrmList = readAlmFile(alrmDat);
        //read from file to init alarm screen
    }
    public aFileIO(List<AlarmInt> alrmEntry, File alrmFile){
        setAlrmList(alrmEntry);
        writeAlmFile(alrmEntry, alrmFile);
        //this.alrmList = alrmEntry;
        //write to file from test data
    }
    public aFileIO(Alarm alarm, File alrmFile){
        List<AlarmInt> aList = new ArrayList<AlarmInt>();
        aList.add(alarm);
        writeAlmFile(aList, alrmFile);
        //write to file from set alarm
    }

    public List<AlarmInt> getAlrmList(){
        return this.alrmList;
    }

    public void setAlrmList(List<AlarmInt> aList){
        this.alrmList = aList;
    }

public List<AlarmInt> readAlmFile(File alrmDat){

    List<AlarmInt> alarmList = new ArrayList<AlarmInt>();
    try{
        System.out.println(">>>>>>>>>>>>>>>>>>>>IMA TRY<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        //File alrmDat = new File("alrDat.txt");
        FileReader fileReader = new FileReader(alrmDat);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + line + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            String[] array = line.split("\\.");
            stringBuffer.append("\n");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + array[0] + "/" + array[1] + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            stringBuffer.append("\n");
            Alarm alarm = new Alarm(array[0], array[1]);
            alarmList.add(alarm);
            //split line into data
            //input into alarm list
        }
        fileReader.close();
    } catch(IOException e) {
        //test to make sure this works with empty file, no file, etc!
        System.out.println(">>>>>>>>>>>>>>>>>>>>I DIDN'T TRY<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return alarmList;
    }
    return alarmList;
    }

public void writeAlmFile(List<AlarmInt> alarmList, File alrmFile){
    try {
        System.out.println(">>>>>>>>>>>>>>>>>>>>" + "Trying to write to file" + "<<<<<<<<<<<<<<<<<<<<<<<<");
        //FileWriter fWrite = new FileWriter("alrmDat.txt");

        //File alrmDat = new File(context.getFilesDir(), "alrDat.txt");
        //OutputStreamWriter dOut = new OutputStreamWriter(alrmFile);

        alrmFile.createNewFile();
        FileOutputStream fOut = new FileOutputStream(alrmFile, true);
        OutputStreamWriter sOut = new OutputStreamWriter(fOut);


        for (AlarmInt aInt : alarmList) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>" + "Trying to write " + aInt.getDate() + "." + aInt.getTime() + "<<<<<<<<<<<<<<<<<<<<<<<<");
            sOut.append(aInt.getDate() + "." + aInt.getTime() + "\n");
            //Alist.add(aInt.getDate() + "." + aInt.getTime());
            //fWrite.write(aInt.getDate() + "." + aInt.getTime() + "\n");
        }
        sOut.close();
        fOut.flush();
        fOut.close();
        //fWrite.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

}

public void deleteAlrmFile(File alrmFile){
    alrmFile.delete();
}
}

