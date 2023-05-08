public class Botella extends Elemento {
    private static final Integer PESO_PROPIO = 4;
    private Elemento contenido;

    public Botella() {
        setPeso(PESO_PROPIO);
        generarNombre();
        setTipo(TipoElemento.RECIPIENTE);
    }    

    /**
     * Llena la botella con el liquido indicado agregando el peso del
     * nuevo liquido. Genera el nuevo nombre de la botella y actualiza
     * el peso.
     * 
     * Solo puede rellenarse cuando esta vacia. Si tiene contenido,
     * debe imprimir el mensaje:
     *    "<botella>: Se encuentra llena"
     * siendo <botella> el texto provisto por toString().
     * 
     * Si el elemento no es del tipo "liquido", debe imprimir el mensaje:
     *    "<botella>: No admite <elemento>"
     * siendo <botella> el texto provisto por toString() y <elemento> la
     * descripcion del elemento entregado (toString()).
     * 
     * @param liquido El liquido para rellenar la botella
     */
    public void llenarBotella (Elemento liquido) {
       //liquido.getPeso()>=0 se me ocurre a mi
        if(liquido.getTipo()==TipoElemento.LIQUIDO){
            if(this.isVacia()){
                
                this.contenido=liquido;
                this.setPeso(this.getPeso()+liquido.getPeso());
                generarNombre();
            }
            else{
                //TODO
                System.out.println(this);
            }

        }
        else {
            //TODO
            System.out.println(this);
        }

        
    }

    /**
     * Vacia el contenido de la botella y actualiza el peso.
     * La botella queda lista para recargar.
     * Genera el nuevo nombre de la botella.
     * 
     * @return El contenido de la botella.
     */
    public Elemento vaciarBotella () {
        setPeso(this.getPeso()-contenido.getPeso());
        Elemento auxContenido=contenido;
        contenido=null;
        generarNombre();
        return auxContenido;
    }

    /**
     * Establece la descripcion de la botella con su contenido
     * correspondiente, por ej. "Botella con Agua".
     * En caso de que no tenga contenido, utiliza el texto
     * "Botella vacia"
     */
    public void generarNombre () {
        
        if(isVacia()){
            setNombre("Botella vacia");
        }
        else{
            setNombre("Botella con "+contenido.getNombre());
        }
    }

    /**
     * Devuelve verdadero en caso de contener algun tipo de pocima
     * y falso si esta vacia o contiene otro tipo de liquido.
     * 
     * @return true en caso de contener algun tipo de pocima.
     */
    public Boolean hasPocima () {
       
        return (!isVacia() && contenido.getNombre().contains("Pocima"));
    }

    /**
     * Devuelve verdadero en caso de contener agua
     * y falso si esta vacia o contiene otro tipo de liquido.
     * 
     * @return true en caso de contener agua
     */
    public Boolean hasAgua () {
        return (!isVacia() && contenido.getNombre().contains("Agua"));
    }
  
    /**
     * Devuelve verdadero en caso de contener vino
     * y falso si esta vacia o contiene otro tipo de liquido.
     * 
     * @return true en caso de contener vino
     */
    public Boolean hasVino () {
        return (!isVacia() && contenido.getNombre().contains("Vino"));
    }
  
    /**
     * Devuelve verdadero o falso segun tenga o no contenido.
     * 
     * @return true en caso de estar vacia
     */
    public Boolean isVacia () { 
        return contenido == null;
    }

    public Elemento getContenido() {
        return contenido;
    }

    public void setContenido(Elemento contenido) {
        this.contenido = contenido;
    }

}