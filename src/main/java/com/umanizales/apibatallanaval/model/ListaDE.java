package com.umanizales.apibatallanaval.model;

import com.umanizales.apibatallanaval.model.dto.CoordenadaDTO;
import com.umanizales.apibatallanaval.model.dto.DistribucionBarcoDTO;
import com.umanizales.apibatallanaval.model.dto.RespuestaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ListaDE implements Serializable {
    private NodoDE cabeza;
    private int cont;

    public int contarNodos() {
        if (cabeza == null) {
            return 0;
        } else {
            int cont = 1;
            NodoDE temp = cabeza;
            while (temp.getSiguiente() != null) {
                cont++;
                temp = temp.getSiguiente();
            }
            return cont;
        }
    }

    public void adicionarNodo(Object dato) {
        if (cabeza == null) {
            cabeza = new NodoDE(dato);
        } else {
            //LLamar a mi ayudante y ubicarme en el último
            NodoDE temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            ///Parado en el ultimo
            temp.setSiguiente(new NodoDE(dato));
            temp.getSiguiente().setAnterior(temp);
        }
        cont++;
    }

    public void adicionarNodoAlInicio(NodoDE nodo) {  // REVISAR ESTE METODO!!!
        if (cabeza == null) {
            cabeza = nodo;
        } else {
            NodoDE temp = cabeza;
            cabeza = nodo;
            cabeza.setSiguiente(temp);
        }
    }


    public boolean validarExistenciaCoordenadas(CoordenadaDTO[] coordenadas) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp != null) {
                for (CoordenadaDTO coord : coordenadas) {
                    if (((DistribucionBarcoDTO) temp.getDato()).validarExistenciaCoordenada(coord)) {
                        return true;
                    }
                }
                temp = temp.getSiguiente();
            }
        }
        return false;
    }

    public ListaDE clonarLista() {
        ListaDE listaCopia = new ListaDE();
        NodoDE temp = cabeza;
        while (temp != null) {
            listaCopia.adicionarNodo(temp.getDato());
            temp = temp.getSiguiente();
        }
        return listaCopia;
    }

    public Object encontrarDatoxCodigo(String codigo) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp != null) {
                if (temp.getDato().equals(codigo)) {
                    return temp.getDato();
                }
                temp = temp.getSiguiente();
            }
        }
        return null;
    }

    public DistribucionBarcoDTO encontrarxPosicion(int posicion) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            int cont = 1;
            while (posicion != cont) {
                temp = temp.getSiguiente();
                cont++;
            }
            /// Estamos parados en el que estabamos buscando
            return (DistribucionBarcoDTO) temp.getDato();
        }
        return null;
    }

    public boolean validarCoordenadasNodo(CoordenadaDTO[] coordenada) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (cabeza.getSiguiente() != null) {
                if (cabeza.getDato() == coordenada) {
                    return true;
                }
            }

            return false;
        }
        return false;
    }
}