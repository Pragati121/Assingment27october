package EnumPack;

public enum addTocratEnum {
    SearchInput("twotabsearchtextbox"),
    SearchButton("nav-search-submit-button");
    private String name;
    addTocratEnum(String name)
    {
        this.name = name;
    }
    public String getResourcesName()
    {
        return name;
    }

}
