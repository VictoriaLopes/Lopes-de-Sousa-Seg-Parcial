public class RegistroAislar {
    private int kid;
    private String barrio;
    public RegistroAislar() {
    }
    public RegistroAislar(int kitTest, String barrio) {
        this.kid = kitTest;
        this.barrio = barrio;
    }
    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
}