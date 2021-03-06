package testrestclient.model;

public class Customer {
    private final long id;
    private final String key;
    private final String name;

    public Customer(long id, String key, String name) {
        this.id = id;
        this.key = key;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}
