package AccessModifier;

public class AccessModifier2 {

    private String secret;
    private String getSecret(){
        return this.secret;
    }

    String defaultString ="Default";

    protected String protectedString = "같은 패키지 Protected";
    public String publicAccess1 = "같은 패키지 클래스";
}
