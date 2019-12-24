import sun.plugin2.message.Message;

public class Model {

    private String name;
    private String symbol;
    private Double price;
    private String icon;
    private String main;

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name ="Эфир";
//    }

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
        this.main = main;
    }
}
