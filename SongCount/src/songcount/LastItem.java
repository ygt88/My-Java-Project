/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songcount;

/**
 *
 * @author ygt
 */
public class LastItem {
    
    public String playID;
    public long songID;
    public long clientID;
    public String dateID;
    
    public LastItem()
    {
        playID = "";
        songID = 0;
        clientID = 0;
        dateID = "";
    }
    public LastItem(String newplayID,long newsongID,long newclientID,String newdateID)
    {
        playID = newplayID;
        songID = newsongID;
        clientID = newclientID;
        dateID = newdateID;
    }
    public String getplayID()
    {
        return playID;
    }
    public long getsongID()
    {
        return songID;
    }
    public long getclientID()
    {
        return clientID;
    }
    public String getdateID()
    {
        return dateID;
    }
    public void setplayID(String newplayID)
    {
        playID = newplayID;
    }
    public void setsongID(long newsongID)
    {
        songID = newsongID;
                
    }
    public void setclientID(long newclientID)
    {
        clientID = newclientID;
    }
    public void setdateID(String newdateID)
    {
        dateID = newdateID;
    }
    public String toString()
    {
        String result = "";
        result = "The play ID of Last List is : "+playID+" then the Song ID of Last List is : "+Long.toString(songID)+" then the client ID of Last List is : "+Long.toString(clientID)+" and the Date of time of Last List is : "+dateID;
        return result;
    }
}
