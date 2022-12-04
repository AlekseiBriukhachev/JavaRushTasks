package com.javarush.task.jdk13.task11.task1113;

public class Laptop {
    private final String name;
    private final OperatingSystem os;

    public Laptop(String laptopName, String osName, String osVersion) {
        //напишите тут ваш код
        os = new OperatingSystem(osName, osVersion);
        name = laptopName;
    }

    public String getName() {
        return name;
    }
    public void updateOS(String version){
        os.setVersion(version);
    }
    public void printInfo(){
        System.out.println("Laptop name: " + "\t" + name);
        System.out.println("OS name: " + "\t" + os.getName());
        System.out.println("OS version: " + "\t" + os.getVersion());
    }
}
