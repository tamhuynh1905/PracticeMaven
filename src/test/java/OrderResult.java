public class OrderResult {
    boolean created;
    String orderId;

    public OrderResult(boolean created, String orderId){
        setCreated(created);
        setOrderId(orderId);
    }

    public OrderResult(){

    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
