package Variety.pojo;

public class OrderItem {
    private  int id;
    private  String name;
    private int count;
    private float price;
    private  float total_price;
    private  String order_id;

    public OrderItem() {
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", total_price=" + total_price +
                ", order_id='" + order_id + '\'' +
                '}';
    }

    public OrderItem(int id, String name, int count, float price, float total_price, String order_id) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.total_price = total_price;
        this.order_id = order_id;
    }

    public OrderItem(String name, int count, float price, float total_price, String order_id) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.total_price = total_price;
        this.order_id = order_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public float getPrice() {
        return price;
    }

    public float getTotal_price() {
        return total_price;
    }

    public String getOrder_id() {
        return order_id;
    }
}
