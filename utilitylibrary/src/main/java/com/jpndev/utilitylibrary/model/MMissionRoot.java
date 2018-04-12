package com.jpndev.utilitylibrary.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MMissionRoot
{
    private long total;

    private long count;

    private Missions[] missions;

    private Object offset;



    public Missions[] getResults ()
    {
        return missions;
    }
    public ArrayList<Missions> getResultsList() {
        ArrayList<Missions> arrayList = null;
        try {
            if(missions != null) {
                arrayList = new ArrayList<Missions>(Arrays.asList(missions));

            }
        } catch (Exception e){
            //  Crashlytics.logException(e);
            arrayList = null;
        }

        return arrayList;
    }
    public void addResults (Missions[] results)
    {
        ArrayList<Missions> arrayList =  new ArrayList<Missions>();
        if(getResultsList()!=null)
            arrayList.addAll(getResultsList());
        if(results!=null)
            arrayList.addAll(Arrays.asList(results));
        if(arrayList!=null)
            this.missions=arrayList.toArray( (new Missions[arrayList.size()]));


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

    public Missions[] getMissions ()
    {
        return missions;
    }

    public void setMissions (Missions[] missions)
    {
        this.missions = missions;
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
        return "ClassPojo [total = "+total+", count = "+count+", missions = "+missions+", offset = "+offset+"]";
    }


    public class Missions
    {
        private String id;

        private String wikiURL;

        private String description;

        private String name;

        private String infoURL;

        private String type;

        private String[] infoURLs;

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

        public String getDescription ()
        {
            return description;
        }

        public void setDescription (String description)
        {
            this.description = description;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getInfoURL ()
        {
            return infoURL;
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
        @Override
        public String toString()
        {
            return "ClassPojo [id = "+id+", wikiURL = "+wikiURL+", description = "+description+", name = "+name+", infoURL = "+infoURL+", type = "+type+", infoURLs = "+infoURLs+"]";
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