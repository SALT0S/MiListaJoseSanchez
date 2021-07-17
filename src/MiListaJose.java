public class MiListaJose {
    public static void main(String[] args) throws Exception {
        MiListaJoseSanchez lista = new MiListaJoseSanchez();
        lista.insertar(new Estudiante("Software", "Segundo", "Yassine Puerto ", 19));
        lista.insertar(new Estudiante("Software", "Noveno", "Virtudes García", 23));
        lista.insertar(new Estudiante("Software", "Cuarto", "Pedro Anton    ", 20));
        lista.insertar(new Estudiante("Software", "Decimo", "Miguel Nevado  ", 26));
        lista.insertar(new Estudiante("Software", "Primero", "Jose Domingo   ", 18));

        System.out.println("\t\t\tLISTA DE ALUMNOS:");
        lista.mostrar();

        System.out.println("\n\n\t\t\tDATOS DEL ALUMNOS Solicitado (4to Elemento)");
        lista.mostrarPorPosicion(1);

        System.out.println("\n\n\t\t\tLISTA DE ALUMNOS CON UN ELEMENTO ELIMINADO (4to Elemento)");
        lista.removerPorPosicion(3);
        lista.mostrar();
    }

    public static class MiNodo {
        private Estudiante dato;
        private MiNodo siguiente;

        public MiNodo(Estudiante dato, MiNodo siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }

        public Estudiante getDato() {
            return dato;
        }

        public void setDato(Estudiante dato) {
            this.dato = dato;
        }

        public MiNodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(MiNodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    public static class MiListaJoseSanchez {
        private MiNodo inicio;
        private MiNodo fin;
        private int tamanio;

        public MiListaJoseSanchez() {
            this.inicio = null;
            this.tamanio = 0;
        }

        public int getTamanio() {
            return tamanio;
        }

        public void setTamanio(int tamanio) {
            this.tamanio = tamanio;
        }

        public boolean esVacia() {
            if (inicio == null) {
                return true;
            } else {
                return false;
            }
        }

        public void insertar(Estudiante m) {
            MiNodo nuevo;
            if (esVacia()) {
                nuevo = new MiNodo(m, null);
                inicio = nuevo;
                fin = nuevo;
            } else {
                nuevo = new MiNodo(m, null);
                fin.setSiguiente(nuevo);
                fin = nuevo;
                tamanio += 1;
            }
        }

        public void mostrar() {
            if (!esVacia()) {
                MiNodo aux = inicio;
                int i = 0;
                while (aux != null) {
                    System.out.print("\n" + i + ".[ " + aux.getDato().toString() + " ]");
                    aux = aux.getSiguiente();
                    i += 1;
                }
            } else {
                System.out.println("La lista está vacía.");
            }
        }

        public void removerPorPosicion(int posicion) {
            if (posicion >= 0 && posicion < tamanio) {
                if (posicion == 0) {
                    inicio = inicio.getSiguiente();
                } else {
                    MiNodo aux = inicio;
                    for (int i = 0; i < posicion - 1; i += 1) {
                        aux = aux.getSiguiente();
                    }
                    MiNodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(siguiente.getSiguiente());
                }
                tamanio -= 1;
            }
        }

        void mostrarPorPosicion(int i) {
            if (!esVacia()) {
                MiNodo aux = inicio;
                for (int b = 0; b <= i; b += 1) {
                    aux = aux.getSiguiente();
                }
                System.out.print("\n" + i + ".[ " + aux.getDato().toString() + " ]");
            } else {
                System.out.println("La lista está vacía.");
            }
        }
    }

    public static class Persona {
        public String nombre;
        public int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombre + "  ||  Edad: " + edad;
        }
    }

    public static class Estudiante extends Persona {
        private String carrera;
        private String semestre;

        public Estudiante(String carrera, String semestre, String nombre, int edad) {
            super(nombre, edad);
            this.carrera = carrera;
            this.semestre = semestre;
        }

        public String getCarrera() {
            return carrera;
        }

        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }

        public String getSemestre() {
            return semestre;
        }

        public void setSemestre(String semestre) {
            this.semestre = semestre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        @Override
        public String toString() {
            return super.toString() + "  ||  Carrera: " + carrera + "  ||  Semestre: " + semestre;
        }
    }
}
