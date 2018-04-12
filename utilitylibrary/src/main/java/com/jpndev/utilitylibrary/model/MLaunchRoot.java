package com.jpndev.utilitylibrary.model;



import android.util.Log;

import com.jpndev.utilitylibrary.LogUtilsutility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MLaunchRoot
{
    private long total;

    private Launches[] launches;

    private long count;

    private long offset;

    public Launches[] getResults ()
    {
        return launches;
    }
    public ArrayList<Launches> getResultsList() {
        ArrayList<Launches> arrayList = null;
        try {
            if(launches != null) {
                arrayList = new ArrayList<Launches>(Arrays.asList(launches));

            }
        } catch (Exception e){
          //  Crashlytics.logException(e);
            arrayList = null;
        }

        return arrayList;
    }
    public void addResults (Launches[] results)
    {
        ArrayList<Launches> arrayList =  new ArrayList<Launches>();
        if(getResultsList()!=null)
            arrayList.addAll(getResultsList());
        if(results!=null)
            arrayList.addAll(Arrays.asList(results));
        if(arrayList!=null)
            this.launches=arrayList.toArray( (new Launches[arrayList.size()]));


    }
    public long getTotal ()
    {
        return total;
    }

    public void setTotal (long total)
    {
        this.total = total;
    }

    public Launches[] getLaunches ()
    {
        return launches;
    }

    public void setLaunches (Launches[] launches)
    {
        this.launches = launches;
    }

    public long getCount ()
    {
        return count;
    }

    public void setCount (long count)
    {
        this.count = count;
    }

    public long getOffset ()
    {
        return offset;
    }

    public void setOffset (long offset)
    {
        this.offset = offset;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [total = "+total+", launches = "+launches+", count = "+count+", offset = "+offset+"]";
    }

    public class Launches
    {
        private String id;

        private String name;

        private String tbdtime;

        private String tbddate;

        private String net;

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getTbdtime ()
        {

            return tbdtime;
        }
        public String getTimeAgo ()
        {
            try {
                DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
                Date date = (Date) formatter.parse(net);
                System.out.println(date);

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
                System.out.println("formatedDate : " + formatedDate);
            }catch (Exception e)
            {

            }
            return tbdtime;
        }


        public String getDays() {

            long myTimeOffset = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis());
            long day = 86400000;
            long hour = 3600000;
            long minute = 60000;
         //   February 27, 2018 04:34:00 UTC
            SimpleDateFormat df = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss ");
            //  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
            Date date = null;
            long days = 0;
            long hours = 0;
            long minutes = 0;
            String value = null;
            Calendar postedDay = Calendar.getInstance();
            try {
                date = df.parse(net);
                postedDay.setTime(date);


                long newtime = postedDay.getTimeInMillis() + myTimeOffset;

                postedDay.setTimeInMillis(newtime);

                Log.e("Server Time=====>>", postedDay.getTime() + "");
                Log.e("Current Time=====>>", Calendar.getInstance().getTime() + "");

                LogUtilsutility.LOGD("jithish", "newtime....." + newtime);


                days = (Calendar.getInstance().getTimeInMillis() - postedDay.getTimeInMillis()) / day;

                LogUtilsutility.LOGD("jithish", "days...." + days);

                hours = (Calendar.getInstance().getTimeInMillis() - postedDay.getTimeInMillis()) / hour;

                LogUtilsutility.LOGD("jithish", "hours...." + hours + "   " + Calendar.getInstance().getTimeInMillis());

                minutes = (Calendar.getInstance().getTimeInMillis() - postedDay.getTimeInMillis()) / minute;


                LogUtilsutility.LOGD("jithish", "minutes...." + minutes);

                if(days == 1) {
                    value = " Yesterday";

                } else if(days > 1) {
                    value = String.valueOf(days) + " days ago";

                } else if(days == 0) {


                    if(hours > 12) {
                        value = " Today";
                    } else {


                        if(hours == 0) {

                            if(minutes < 0) minutes = 0;

                            if(minutes == 0) {

                                value = "Moments ago";
                            } else {
                                value = String.valueOf(minutes) + " minutes ago";
                            }


                        } else {
                            value = String.valueOf(hours) + " hours ago";
                        }

                    }

                } else if(days == -1) {
                    value = " Tommorrow";
                } else if(days < -1) {
                    value = "In " + ((~days)+2) + " days";

                    //  value = " Tommorrow";
                }
                return value;

            } catch (Exception e) {
e.printStackTrace();
            }

            return value;

        }




        public void setTbdtime (String tbdtime)
        {
            this.tbdtime = tbdtime;
        }

        public String getTbddate ()
        {
            return tbddate;
        }

        public void setTbddate (String tbddate)
        {
            this.tbddate = tbddate;
        }

        public String getNet ()
        {
            return net;
        }

        public void setNet (String net)
        {
            this.net = net;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [id = "+id+", name = "+name+", tbdtime = "+tbdtime+", tbddate = "+tbddate+", net = "+net+"]";
        }
    }

}