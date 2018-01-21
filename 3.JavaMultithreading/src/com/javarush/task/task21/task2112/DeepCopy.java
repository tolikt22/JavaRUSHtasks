package com.javarush.task.task21.task2112;//: Приложение А:DeepCopy.java
// Клонирование составных объектов

class DepthReading implements Cloneable {
    private double depth;
    public DepthReading(double depth) {
        this.depth = depth;
    }
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
        return o;
    }
}

class TemperatureReading implements Cloneable {
    private long time;
    private double temperature;
    public TemperatureReading(double temperature) {
        time = System.currentTimeMillis();
        this.temperature = temperature;
    }
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
        return o;
    }
}

class OceanReading implements Cloneable {
    private DepthReading depth;
    private TemperatureReading temperature;
    public OceanReading(double tdata, double ddata){
        temperature = new TemperatureReading(tdata);
        depth = new DepthReading(ddata);
    }
    public Object clone() {
        OceanReading o = null;
        try {
            o = (OceanReading)super.clone();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
        // Необходимо клонировать ссылку:
        o.depth = (DepthReading)o.depth.clone();
        o.temperature =
                (TemperatureReading)o.temperature.clone();
        return o; // Передаем его в Object
    }
}

public class DeepCopy {
    public static void main(String[] args) {
        OceanReading reading =
                new OceanReading(33.9, 100.5);
        // Теперь клонируем его:
        OceanReading r =
                (OceanReading)reading.clone();
    }
} ///:~