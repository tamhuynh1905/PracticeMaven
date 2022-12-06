public class Order {
    String toolId;
    String customerName;

    public Order(String toolId, String customerName){
        setToolId(toolId);
        setCustomerName(customerName);
    }

    public Order(){

    }

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public static String requestBody(){
        return "{\n" +
                "    \"toolId\": 4643,\n" +
                "    \"customerName\": \"Tam Huynh\"\n" +
                "}";
    }


}
