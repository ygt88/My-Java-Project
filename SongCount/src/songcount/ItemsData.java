/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songcount;
import java.util.Date;
/**
 *
 * @author ygt
 */
public class ItemsData {
    
        public String PLAY_ID;
	public String SONG_ID;
	public String CLIENT_ID;
	public String PLAY_TS;
	public String other;
	public ItemsData()
	{
		PLAY_ID = "";
		SONG_ID = "";
		CLIENT_ID = "";
		PLAY_TS ="";
                other = "";
	}
	public String getPLAYID()
	{
		return PLAY_ID;
		
	}
	public String getSONGID()
	{
		return SONG_ID;
		
	}
	public String getCLIENTID()
	{
		return CLIENT_ID;
		
	}
	public String getDate()
	{
		return PLAY_TS;
		
	}
        public String getTime()
        {
            return other;
        }
	public void setPLAYID(String ID)
	{
		PLAY_ID = ID;
	}
	public void setSONG(String Song)
	{
		SONG_ID= Song;
	}
	public void setCLIENT(String Client)
	{
		CLIENT_ID = Client;
	}
	public void setDATE(String last)
	{
		PLAY_TS = last;
	}
        public void setTime(String times)
        {
            other = times;
        }
        public String toString()
        {
            String total = "";
            total = "The PLAY_ID of ItemsData is : "+PLAY_ID+" then the SONG ID is : "+SONG_ID+" then the CLIENT ID is :"+CLIENT_ID+" and lastly the date of time is: "+PLAY_TS;
            return total;
        }
}
