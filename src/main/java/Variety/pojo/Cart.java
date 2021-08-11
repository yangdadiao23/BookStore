package Variety.pojo;

import java.util.*;

public class Cart {
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public void addItem(CartItem item) {
        CartItem cartItem = items.get(item.getId());
        if (cartItem == null) {
            items.put(item.getId(), item);
        } else {
            cartItem.setCount(cartItem.getCount() + 1);
            cartItem.setTotalPrice(item.getPrice() * cartItem.getCount());
        }
    }

    public void deleteItem(int id) {
        items.remove(id);

    }

    public void updateCount(int id, int newCount) {
        CartItem cartItem = items.get(id);
        if (cartItem == null) {
            return;
        } else {
            cartItem.setCount(newCount);
            cartItem.setTotalPrice(newCount * cartItem.getPrice());
        }
    }

    public void clearItem() {
        items.clear();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public int getTotalCount() {
        final int[] totalCount = {0};
        items.forEach((a, b) -> {
            totalCount[0] += b.getCount();
        });
        return totalCount[0];
    }


    public float getTotalPrice() {
        final int[] totalPrice = {0};
        items.forEach((a,b)->{
            totalPrice[0] +=b.getTotalPrice();
        });
        return totalPrice[0];
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(items, cart.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
