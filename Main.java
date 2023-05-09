public class Main {
    public static void main(String[] args) {
        Personaje mago = new Personaje("Gandalf", 100, 260);
        Bolsa bolsa = new Bolsa("Mochila",150);
        mago.setBolsa(bolsa);
        mago.mirarAlrededor();
        
        mago.recogerElemento("Carcaj chico");

        mago.guardarElemento();
        mago.recogerElemento("Arco");
        System.out.println(mago.getNombre() + " " + mago.getElemento());
        
        mago.mirarAlrededor();
        mago.irHacia(Salida.NORTE);
        mago.mirarAlrededor();
        mago.irHacia(Salida.OESTE);
        mago.mirarAlrededor();
        mago.recogerElemento("Pluma");
        mago.recogerElemento("Botella");
        System.out.println("Bolsa: " + bolsa.getListaElementosEnLaBolsa());
         
    }
}
