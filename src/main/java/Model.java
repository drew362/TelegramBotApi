//import sun.plugin2.message.Message;

public class Model {

    private String name;
    private String symbol;
    private Double price;
    private String icon;
    private String main;
    private int humidity;
    private int temp;
    private int wind;

    public void setWind(int wind) {
        this.wind = wind;
    }

    public int getWind() {
        return wind;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int
    getHumidity() {
        return humidity;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getTemp() {
        return temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        switch (main) {
            case "Clouds":
                this.main = "Облачно";
                break;
            case "sun":
                this.main = "Солнечно";
                break;
            default:
                this.main = main;
        }
    }
}
