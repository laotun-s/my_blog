package top.laotun.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtils {

    public static String getJson(Object obj) {
        return getJson(obj,"YYYY-MM-DD HH:MM:SS");
    }

    public static String getJson(Object obj,String DateFormat) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        final SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
        mapper.setDateFormat(sdf);
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}