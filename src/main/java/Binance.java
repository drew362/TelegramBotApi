import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Binance {

    public static String getBalance(String message, Model model) throws IOException {

       URL url =new URL("https://api.binance.com/api/v3/ticker/price?symbol=" + message);

        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }


        JSONObject object = new JSONObject(result);
        model.setSymbol(object.getString("symbol"));
        model.setPrice(object.getDouble("price"));

        if(message.equals(100)){

        }
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

