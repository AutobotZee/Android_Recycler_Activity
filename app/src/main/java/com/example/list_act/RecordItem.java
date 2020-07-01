package com.example.list_act;

public class RecordItem {
    private int ID;
    private String CMD;
    private String StartDT;
    private String Address;
    private String Name;

    public RecordItem(int ID, String CMD, String StartDT, String Address, String Name)
    {
        this.ID = ID;
        this.CMD = CMD;
        this.StartDT = StartDT;
        this.Address = Address;
        this.Name = Name;
    }

    public int getID(){return ID;}
    public String getCMD(){ return CMD;}
    public String getStartDT(){ return StartDT;}
    public String getAddress(){ return Address;}
    public String getName(){ return Name;}
}
