package DataAccess;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

//import java.util.List;
//import java.sql.SQLException;
//import com.google.gson.*;
//import com.google.gson.reflect.TypeToken;
//import java.lang.reflect.Type;

public abstract class Dao<T> {
    Gson gson;

    public Dao(){
        createGsonBuilder();
    }

    public Optional<T> get(String username){return null;}

    public ArrayList<T> getAll(){return null;}

    public void save(T t){}

    public void update(T t){}

    public void delete(T t){}

    private void createGsonBuilder(){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(new TypeToken<LocalDate>(){}.getType(), new LocalDateJsonSerializer());
        builder.registerTypeAdapter(new TypeToken<LocalTime>(){}.getType(), new LocalTimeJsonSerializer());
        this.gson = builder.create();
    }

    private class LocalDateJsonSerializer implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
        public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject LCJsonObject = new JsonObject();
            LCJsonObject.addProperty("year", src.getYear());
            LCJsonObject.addProperty("month", src.getMonthValue());
            LCJsonObject.addProperty("day", src.getDayOfMonth());
            return LCJsonObject;
        }

        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject LCJasonString = json.getAsJsonObject();
            return LocalDate.of(LCJasonString.get("year").getAsInt(),LCJasonString.get("month").getAsInt(),LCJasonString.get("day").getAsInt());

        }
    }

    private class LocalTimeJsonSerializer implements JsonSerializer<LocalTime>, JsonDeserializer<LocalTime>{
        public JsonElement serialize(LocalTime src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject LTJsonObject = new JsonObject();
            LTJsonObject.addProperty("hour", src.getHour());
            LTJsonObject.addProperty("minute", src.getMinute());
            return LTJsonObject;
        }

        public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonArray LTJasonString = json.getAsJsonArray();
            return LocalTime.of(LTJasonString.get(0).getAsInt(),LTJasonString.get(1).getAsInt());
        }
    }
}
