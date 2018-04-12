package com.jpndev.utilitylibrary.model;

import com.jpndev.utilitylibrary.LogUtilsutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MRocketsRoot
{
    private long total;

    private long count;

    private Rockets[] rockets;

    private Object offset;


    public Rockets[] getResults ()
    {
        return rockets;
    }
    public ArrayList<Rockets> getResultsList() {
        ArrayList<Rockets> arrayList = null;
        try {
            if(rockets != null) {
                arrayList = new ArrayList<Rockets>(Arrays.asList(rockets));

            }
        } catch (Exception e){
            //  Crashlytics.logException(e);
            arrayList = null;
        }

        return arrayList;
    }
    public void addResults (Rockets[] results)
    {
        ArrayList<Rockets> arrayList =  new ArrayList<Rockets>();
        if(getResultsList()!=null)
            arrayList.addAll(getResultsList());
        if(results!=null)
            arrayList.addAll(Arrays.asList(results));
        if(arrayList!=null)
            this.rockets=arrayList.toArray( (new Rockets[arrayList.size()]));


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

    public Rockets[] getRockets ()
    {
        return rockets;
    }

    public void setRockets (Rockets[] rockets)
    {
        this.rockets = rockets;
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
        return "ClassPojo [total = "+total+", count = "+count+", rockets = "+rockets+", offset = "+offset+"]";
    }

    public class Rockets
    {
        private String id;

        private String wikiURL;

        private Integer[] imageSizes;

        private String name;

        private String infoURL;



        private String[] infoURLs;

        private String imageURL;
/*
        private String defaultPads;

        private String configuration;*/
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

        public Integer[] getImageSizes ()
        {
            return imageSizes;
        }
        public ArrayList<Integer> getImageSizesList() {
            ArrayList<Integer> arrayList = null;
            try {
                if(imageSizes != null) {
                    arrayList = new ArrayList<Integer>(Arrays.asList(imageSizes));

                }
            } catch (Exception e){
                //  Crashlytics.logException(e);
                arrayList = null;
            }

            return arrayList;
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
        public String getValidWebURL ()
        {
            String url=wikiURL;
            try {
                if(isValid(wikiURL)) url = wikiURL;
                else if(isValid(infoURL)) url = infoURL;
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

            }catch (Exception e)
            {
                url=wikiURL;
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
        public void setImageSizes (Integer[] imageSizes)
        {
            this.imageSizes = imageSizes;
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

     /*   public String getDefaultPads ()
        {
            return defaultPads;
        }

        public void setDefaultPads (String defaultPads)
        {
            this.defaultPads = defaultPads;
        }

        public String getConfiguration ()
        {
            return configuration;
        }

        public void setConfiguration (String configuration)
        {
            this.configuration = configuration;
        }*/

        public String[] getInfoURLs ()
        {
            return infoURLs;
        }

        public void setInfoURLs (String[] infoURLs)
        {
            this.infoURLs = infoURLs;
        }

        public String getImageURL ()
        {
            return imageURL;
        }
        public String getThumbnail()
        {
            String imgurl=imageURL;
            try {
                ArrayList<Integer> sizelist =getImageSizesList();

                Collections.sort(sizelist);
                int smallsize=sizelist.get(0);

                if(imgurl.contains("_"))
                {
                    String endpart="";
                    if(imgurl.contains("."))
                    {
                        endpart=  imgurl.substring(imgurl.lastIndexOf('.'));
                    }
                    int index=  imgurl.lastIndexOf("_");
                     String first_part_url=imgurl.substring(0, imgurl.lastIndexOf('_'));
                    first_part_url=first_part_url+"_"+smallsize+endpart;
                    imgurl=first_part_url;
                }

            }catch (Exception e)
            {
                LogUtilsutility.LOGD("exception","getThumbnail exce"+e.getMessage());
                imgurl=imageURL;
            }
            return imgurl;
        }


        public void setImageURL (String imageURL)
        {
            this.imageURL = imageURL;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [id = "+id+", wikiURL = "+wikiURL+", imageSizes = "+imageSizes+", name = "+name+", infoURL = "+infoURL+",  infoURLs = "+infoURLs+", imageURL = "+imageURL+"]";
        }
    }
}
	