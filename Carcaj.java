import java.util.ArrayList;
import java.util.List;

/**
 * Modela el Carcaj que lleva el personaje para
 * tranportar sus flechas.
 */
public class Carcaj extends Elemento {
    private final Integer PESO_PROPIO = 10;
    private Integer capacidad; //en cantidad de flechas no en peso
    private List<Flecha> flechas;

    /**
     * Constructor para un Carcaj generico chico. Su capacidad
     * es de 5 flechas pero se inicializa vacio.
     * Recordar que es de tipo recipiente y tiene un peso inicial.
     */
    public Carcaj() {
       
        setTipo(TipoElemento.RECIPIENTE);//tipo="Recipiente";NO se puede. es atributo privado. ademas es un enum.
        setPeso(PESO_PROPIO);
        setNombre("Carcaj chico");
        capacidad=5;
        //flechas=null;
        flechas=new ArrayList<Flecha>();//flechas=null;
    }

    /**
     * Constructor para un Carcaj de nombre y capacidad indicados
     * por parametro.  Se inicializa vacio.
     * Recordar que es de tipo recipiente y tiene un peso inicial.
     * 
     * @param nombre El nombre del carcaj.
     * @param capacidad Cantidad maxima de flechas.
     */
    public Carcaj(String nombre, Integer capacidad) {
        setTipo(TipoElemento.RECIPIENTE);
        setPeso(PESO_PROPIO);
        setNombre(nombre);
        this.capacidad=capacidad;
        flechas=new ArrayList<Flecha>();
    }

    /**
     * Agrega una flecha al carcaj.
     * 
     * Debe actualizarse el peso total.
     * 
     * Si no tiene capacidad disponible, debe imprimir
     *     "<nombre>: Capacidad completa"
     * donde <nombre> es el nombre del carcaj.
     * 
     * Si el elemento a agregar no es una flecha, debe imprimir:
     *     "<nombre>: No es una flecha"
     * donde <nombre> es el nombre del elemento entregado.
     * 
     * @param flecha La flecha a agregar.
     */
    public void addFlecha (Elemento flecha) {
        
        if(flechas.size()==capacidad){
            System.out.println(this.getNombre()+": Capacidad completa");
        }
        else if(flecha instanceof Flecha){
           flechas.add((Flecha)flecha);
            //se viola el principio tell dont ask
            //al actualizar el peso total...
            //mas adelante hay un metodo que hace esto........
            //this.setPeso(this.getPeso()+flecha.getPeso());
            this.addPeso(flecha.getPeso());
        }
        else{
            System.out.println(flecha.getNombre()+": No es una flecha");
        }
    }

    /**
     * CUIDADO!! PELIGRO!!
     * Quita del carcaj una flecha.
     * 
     * Debe actualizarse el peso total.
     * 
     * Si no hay mas flechas, devuelve null y debe imprimir:
     *      "<nombre>: No quedan flechas"
     * donde <nombre> es el nombre del carcaj.
     * 
     * @return Una flecha.
     */
    public Flecha getFlecha () {
        if(flechas.isEmpty()){
            System.out.println(this.getNombre()+": No quedan flechas");
            return null;
        }


        Flecha flechaEliminada=flechas.remove(0);
        //this.setPeso(this.getPeso()-flechaEliminada.getPeso());
        this.addPeso((-1)*flechaEliminada.getPeso());
        return flechaEliminada;
        
    }

    /**
     * Modifica el peso del carcaj.
     * Puede sumar o restar peso.
     * 
     * @param peso El peso a modificar.
     */
    public void addPeso (Integer peso) {
        this.setPeso(this.getPeso()+peso);
    }

    /**
     * Devuelve informacion sobre el carcaj de la forma:
     *     "<nombre>: Flechas <cant>/<max>"
     * donde <nombre> es el nombre del carcaj,
     * <cant> es la cantidad de flechas que contiene y
     * <max> la capacidad maxima.
     */
    @Override        
    public String toString() {
        return this.getNombre()+": Flechas "+flechas.size()+"/"+capacidad;
    }

    public Integer getCantidadFlechas () {
        return flechas.size();
    }

    public Integer getCapacidad () {
        return capacidad;
    }
    
}
