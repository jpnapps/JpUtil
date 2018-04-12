package com.jpndev.utilitylibrary.model;

import java.util.ArrayList;
import java.util.Arrays;

public class MPadRoot
{
    private long total;

    private long count;

    private Pads[] pads;

    private Object offset;


    public Pads[] getResults ()
    {
        return pads;
    }
    public ArrayList<Pads> getResultsList() {
        ArrayList<Pads> arrayList = null;
        try {
            if(pads != null) {
                arrayList = new ArrayList<Pads>(Arrays.asList(pads));

            }
        } catch (Exception e){
            //  Crashlytics.logException(e);
            arrayList = null;
        }

        return arrayList;
    }
    public void addResults (Pads[] results)
    {
        ArrayList<Pads> arrayList =  new ArrayList<Pads>();
        if(getResultsList()!=null)
            arrayList.addAll(getResultsList());
        if(results!=null)
            arrayList.addAll(Arrays.asList(results));
        if(arrayList!=null)
            this.pads=arrayList.toArray( (new Pads[arrayList.size()]));


    }

    public long getTotal ()
    {
        return total;
    }

    public void setTotal (long total)
    {
        this.total = total;
    }

    public long getCount ()
    {
        return count;
    }

    public void setCount (long count)
    {
        this.count = count;
    }

    public Pads[] getPads ()
    {
        return pads;
    }

    public void setPads (Pads[] pads)
    {
        this.pads = pads;
    }

    public Object getOffset ()
    {
        return offset;
    }

    public void setOffset (Object offset)
    {
        this.offset = offset;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [total = "+total+", count = "+count+", pads = "+pads+", offset = "+offset+"]";
    }

    public class Pads
    {
        private String padType;

        private String id;

        private String wikiURL;

        private String locationid;

        private String mapURL;

        private String name;

        private String retired;

        private String longitude;

        private String infoURL;

        private String latitude;

        private String[] infoURLs;

        public String getPadType ()
        {
            return padType;
        }

        public void setPadType (String padType)
        {
            this.padType = padType;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getWikiURL ()
        {
            return wikiURL;
        }

        public void setWikiURL (String wikiURL)
        {
            this.wikiURL = wikiURL;
        }

        public String getLocationid ()
        {
            return locationid;
        }

        public void setLocationid (String locationid)
        {
            this.locationid = locationid;
        }

        public String getMapURL ()
        {
            return mapURL;
        }

        public void setMapURL (String mapURL)
        {
            this.mapURL = mapURL;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getRetired ()
        {
            return retired;
        }

        public void setRetired (String retired)
        {
            this.retired = retired;
        }

        public String getLongitude ()
        {
            return longitude;
        }

        public void setLongitude (String longitude)
        {
            this.longitude = longitude;
        }

        public String getInfoURL ()
        {
            return infoURL;
        }

        public void setInfoURL (String infoURL)
        {
            this.infoURL = infoURL;
        }

        public String getLatitude ()
        {
            return latitude;
        }

        public void setLatitude (String latitude)
        {
            this.latitude = latitude;
        }

        public String[] getInfoURLs ()
        {
            return infoURLs;
        }

        public void setInfoURLs (String[] infoURLs)
        {
            this.infoURLs = infoURLs;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [padType = "+padType+", id = "+id+", wikiURL = "+wikiURL+", locationid = "+locationid+", mapURL = "+mapURL+", name = "+name+", retired = "+retired+", longitude = "+longitude+", infoURL = "+infoURL+", latitude = "+latitude+", infoURLs = "+infoURLs+"]";
        }
    }
}
