import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Weather {


    public static String getWeather(String message, Model model) throws IOException {

        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + message + "&units=metric&limit=5&appid=5863dfab44f9a0d417e96285ed59fbe9");

        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }

        JSONObject object = new JSONObject(result);
        model.setName(object.getString("name"));

        JSONObject main = object.getJSONObject("main");
        model.setTemp(main.getInt("temp"));
        model.setHumidity(main.getInt("humidity"));
        model.setPressure(main.getDouble("pressure"));


        JSONArray getArray = object.getJSONArray("weather");
        for (int i = 0; i < getArray.length(); i++) {
            JSONObject obj = getArray.getJSONObject(i);
            model.setIcon((String) obj.get("icon"));
            model.setMain((String) obj.get("main"));
        }

        JSONObject wind = object.getJSONObject("wind");
        model.setWind(wind.getInt("speed"));


        return "Город: " + model.getName() + "\n" +
                "Температура: " + model.getTemp() + " °C" + "\n" +
                "Влажность: " + model.getHumidity() + " %" + "\n" +
                "Ветер: " + model.getWind() + " м/с" + "\n" +
                "Давление: " + model.getPressure() + " мм рт. ст." + "\n" +
                "https://openweathermap.org/img/w/" + model.getIcon() + ".png" + "\n" +
                model.getMain();
    }

}

