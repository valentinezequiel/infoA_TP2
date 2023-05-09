/**
 * Esta clase modela un personaje de un juego de rol.
 */
public class Personaje {
    private final Integer MAX_VIDA;
    private final Integer PESO_MAXIMO_BOLSA;
    // nombre -> el nombre del personaje
    private String nombre;
    // vida -> valor actual de vida
    private Integer vida;
    // objeto -> el elemento que tiene en sus manos
    //           Puede tener las manos vacias (null)
    private Elemento objeto;
    // bolsa -> la Bolsa de elementos
    private Bolsa bolsa;
    // El lugar donde se encuentra el personaje
    private Habitacion habitacion;

    /**
     * Crea un personaje con el nombre dado y configura los
     * campos segun vida, MAX_VIDA y PESO_MAXIMO_BOLSA.
     * 
     * El personaje se inicializa sin bolsa y con las manos vacias
     * en la habitacion inicial del mapa (getInicio()).
     * 
     * @param nombre El nombre del personje.
     * @param vida El valor inicial y maximo de vida del personaje.
     * @param peso El peso maximo que puede transportar el personaje.
     */
    public Personaje (String nombre, Integer vida, Integer peso) {
       MAX_VIDA=vida;
       this.vida=vida;
       PESO_MAXIMO_BOLSA=peso;
       this.nombre=nombre;
       bolsa=null;
       objeto=null;
       habitacion=Mapa.getInstance().getInicio();

    }

    /**
     * Imprime en pantalla la informacion sobre el lugar
     * donde se encuentra.
     */
    public void mirarAlrededor () {
        System.out.println(habitacion.getDescripcionLarga());
    }

    /**
     * El personaje se mueve a la habitacion en la direccion
     * indicada. Si la direccion no es valida, se queda
     * donde estaba.
     * 
     * @param direccion Direccion por donde salir de la habitacion
     */
    public void irHacia (Salida direccion) {
        habitacion=habitacion.getSalida(direccion);
    } 

    /**
     * Guarda el elemento que tiene en sus manos en la bolsa, siempre
     * y cuando haya lugar suficiente.  Las manos quedan vacias (null).
     * 
     * Si las manos estan vacias (null), mostrar "No hay elemento
     * para agregar a la bolsa"
     * 
     * Si no hay bolsa (null), mostrar "No hay bolsa"
     */
    public void guardarElemento() {
        if(bolsa==null){
            System.out.println("No hay bolsa");
        }
        else if(objeto==null){
            System.out.println("No hay elemento para agregar a la bolsa");
        }
        else{
            if(bolsa.getPesoLibre()>=objeto.getPeso()){
                bolsa.addElemento(objeto);
                objeto=null;
            }
        }
    }

    /**
     * Toma un elemento de la bolsa (getElemento) y lo pone
     * en las manos del personaje.
     * 
     * Si tiene un elemento en sus manos, imprimir "Manos ocupadas".
     * 
     * Si no hay bolsa, imprimir "No hay bolsa"
     * 
     * Si no existe el elemento se debe imprimir
     *       "No se cuenta con el <nombre>"
     * donde <nombre> es el nombre del elemento buscado.
     * 
     * @param nombre El elemento a tomar de la bolsa.
     */
    public void tomarElemento (String nombre) {
        if(objeto!=null){
            System.out.println("Manos ocupadas");
        }
        else if(bolsa==null){
            System.out.println("No hay bolsa");
        }
        else{
            objeto=bolsa.getElemento(nombre);
            if(objeto==null){
                System.out.println("No se cuenta con el "+nombre);
            }
        }
    }
    
    /**
     * Toma de la habitacion el elemento indicado con sus manos. 
     * De ser necesario, debe guardar en la bolsa lo que tenga
     * en sus manos.
     *
     * Si el elemento no existe, debe seguir sosteniendo el
     * elemento que tenia en sus manos.
     * 
     * @param nombre Nombre del objeto a recoger de la habitacion.
     */
    public void recogerElemento (String nombre) {
     //jaja error xq metodo destructivo
     Elemento elemento=habitacion.getElemento(nombre);
        if(elemento!=null)
        {
            if(objeto!=null){
                guardarElemento();//y que pasa si no lo puede guardar???                
            }
            objeto=elemento;

        }
    }

    /**
     * Deja en la habitacion el elemento que tiene en sus manos.
     * Las manos quedan vacias (null).
     * 
     * Si las manos estan vacias imprime el mensaje:
     *      "No hay objeto para dejar"
     */
    public void dejarElemento () {
        if(objeto==null){
            System.out.println("No hay objeto para dejar");
        }
        else{
            habitacion.addElemento(objeto);
            objeto=null;
        }
    }


    /**
     * Establece la nueva bolsa para el personaje.
     * 
     * @param bolsa La nueva bolsa del personaje.
     */
    public void setBolsa(Bolsa bolsa) {
        if (bolsa.getPesoMaximo() > PESO_MAXIMO_BOLSA) {
            System.out.println("Bolsa inapropiada");
        }
        else {
            this.bolsa = bolsa;
        }
    }

    /**
     * Devuelve la bolsa del personaje.
     * 
     * @return La bolsa del personaje.
     */
    public Bolsa getBolsa() {
        return bolsa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public void resetVida(Integer vida) {
        this.vida = MAX_VIDA;
    }

    public Elemento getElemento () {
        return objeto;
    }

    public void setElemento (Elemento objeto) {
        this.objeto = objeto;
    }
    
    public void setHabitacion(Habitacion habitacion) {
    	this.habitacion=habitacion;  	
    }

}
