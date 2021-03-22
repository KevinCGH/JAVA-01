package io.kimmking.rpcfx.demo.api;

/**
 * Order
 *
 * @author KevinChen
 * @since 22/3/2021
 */
public class Order {
    private int id;
    private String name;
    private float amount;

    public Order(int id, String name, float amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
