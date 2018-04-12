package com.jpndev.utilitylibrary.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MAgencyRoot
{
    private long total;

    private long count;

    private Agencies[] agencies;

    private Object offset;



    public Agencies[] getResults ()
    {
        return agencies;
    }
    public ArrayList<Agencies> getResultsList() {
        ArrayList<Agencies> arrayList = null;
        try {
            if(agencies != null) {
                arrayList = new ArrayList<Agencies>(Arrays.asList(agencies));

            }
        } catch (Exception e){
            //  Crashlytics.logException(e);
            arrayList = null;
        }

        return arrayList;
    }
    public void addResults (Agencies[] results)
    {
        ArrayList<Agencies> arrayList =  new ArrayList<Agencies>();
        if(getResultsList()!=null)
            arrayList.addAll(getResultsList());
        if(results!=null)
            arrayList.addAll(Arrays.asList(results));
        if(arrayList!=null)
            this.agencies=arrayList.toArray( (new Agencies[arrayList.size()]));


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

    public Agencies[] getAgencies ()
    {
        return agencies;
    }

    public void setAgencies (Agencies[] agencies)
    {
        this.agencies = agencies;
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
        return "ClassPojo [total = "+total+", count = "+count+", agencies = "+agencies+", offset = "+offset+"]";
    }

    public class Agencies
    {
        private String id;

        private String wikiURL;

        private String islsp;

        private String name;

        private String countryCode;

        private String abbrev;

        private String infoURL;

        private String type;

        private String[] infoURLs;

        public ArrayList<String> getValidWebURLs ()
        {
            ArrayList<String> urls=new ArrayList<String>();
            try {
                if(isValid(wikiURL)) urls.add(wikiURL);
                if(isValid(infoURL)) urls.add(infoURL);
                if(isValid(infoURLs))
                {
                    for(int i=0;i<infoURLs.length;i++)
                    {
                        if(isValid(infoURLs[i])) {
                            urls.add(infoURLs[i]);
                            //  break;
                        }
                    }
                }

            }catch (Exception e)
            {
                if(isValid(wikiURL)) urls.add(wikiURL);
                if(isValid(infoURL)) urls.add(infoURL);
            }

            return urls;
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

        public String getIslsp ()
        {
            return islsp;
        }

        public void setIslsp (String islsp)
        {
            this.islsp = islsp;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getCountryCode ()
        {
            return countryCode;
        }

        public void setCountryCode (String countryCode)
        {
            this.countryCode = countryCode;
        }

        public String getAbbrev ()
        {
            return abbrev;
        }

        public void setAbbrev (String abbrev)
        {
            this.abbrev = abbrev;
        }

        public String getInfoURL ()
        {
            return infoURL;
        }
        public String getValidInfoURL ()
        {
            String url=infoURL;
            try {
                if(isValid(infoURL)) url = infoURL;
                else if(isValid(infoURLs))
                {
                    for(int i=0;i<infoURLs.length;i++)
                    {
                        if(isValid(infoURLs[i])) {
                            url = infoURLs[i];
                            break;
                        }
                    }
                }
                else if(isValid(wikiURL)) url = wikiURL;
            }catch (Exception e)
            {
                url=infoURL;
            }

            return url;
        }
        public void setInfoURL (String infoURL)
        {
            this.infoURL = infoURL;
        }

        public String getType ()
        {
            return type;
        }

        public void setType (String type)
        {
            this.type = type;
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
            return "ClassPojo [id = "+id+", wikiURL = "+wikiURL+", islsp = "+islsp+", name = "+name+", countryCode = "+countryCode+", abbrev = "+abbrev+", infoURL = "+infoURL+", type = "+type+", infoURLs = "+infoURLs+"]";
        }

        public Boolean isValid(String text) {
            if (text != null)
                if (!text.trim().equalsIgnoreCase(""))
                    return true;
            return false;

        }

        public Boolean isValid(List list) {
            if (list != null)
                if (list.size() > 0)
                    return true;
            return false;

        }
        public Boolean isValid(String[] list) {
            if (list != null)
                if (list.length > 0)
                    return true;
            return false;

        }
    }


}
