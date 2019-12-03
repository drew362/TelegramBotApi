import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Binance {

    public static String getWeather(String message, Model model) throws IOException {
      //  URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + message + "&units=metric&appid=6fff53a641b9b9a799cfd6b079f5cd4e");
       URL url =new URL("https://api.binance.com/api/v3/ticker/price?symbol=" + message);
//String coin  = ETHUSDC;
        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }

        JSONObject object = new JSONObject(result);
    //    model.setName(object.getString("name"));
        model.setSymbol(object.getString("symbol"));
        model.setPrice(object.getDouble("price"));

       // JSONArray getArray = object.getJSONArray("weather");
//        for (int i = 0; i < getArray.length(); i++) {
//            JSONObject obj = getArray.getJSONObject(i);
//            model.setIcon((String) obj.get("icon"));
//            model.setMain((String) obj.get("main"));
      //  }

        return
                "Пара: " + model.getSymbol()  +
                " Цена: " + model.getPrice();
    }
}
