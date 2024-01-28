package endpoints;

public enum UserEndpoints {   // нумерация , создаю конструктор и геттер


    CREATE_USER ("/v2/user"),
    DELETE_USER ("/v2/user/Batman");

    private final String endpoints;

    UserEndpoints(String endpoints) {
        this.endpoints = endpoints;
    }

    public String getEndpoints() {
        return endpoints;
    }
}
