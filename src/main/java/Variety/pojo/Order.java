package Variety.pojo;

import java.util.Date;

public class Order {
    private  String order_id;
    private Date create_time;
    private  float price;
    private  int status=0;
    private  int User_id;

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", create_time=" + create_time +
                ", price=" + price +
                ", status=" + status +
                ", User_id=" + User_id +
                '}';
    }

    public Order() {
    }

    public Order(String order_id, Date create_time, float price, int status, int user_id) {
        this.order_id = order_id;
        this.create_time = create_time;
        this.price = price;
        this.status = status;
        User_id = user_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }
}


