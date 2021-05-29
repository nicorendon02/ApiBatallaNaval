package com.umanizales.apibatallanaval.model;

import com.umanizales.apibatallanaval.model.dto.CoordenadaDTO;
import com.umanizales.apibatallanaval.model.dto.DistribucionBarcoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListaDE implements Serializable {
    private NodoDE cabeza;
    private int cont;

    public void adicionarNodo(Object dato){
        if(cabeza == null)
        {
            cabeza = new NodoDE(dato);
        }
        else
        {
            //LLamar a mi ayudante y ubicarme en el último
            NodoDE temp = cabeza;
            while(temp.getSiguiente()!=null)
            {
                temp= temp.getSiguiente();
            }
            ///Parado en el ultimo
            temp.setSiguiente(new NodoDE(dato));
            temp.getSiguiente().setAnterior(temp);
        }
        cont++;
    }

    public void adicionarNodoAlInicio(Object dato){
        if(cabeza == null)
        {

        }

    }

    public ListaDE clonarLista()
    {
        ListaDE listaCopia= new ListaDE();
        NodoDE temp = cabeza;
        while(temp!=null)
        {
            listaCopia.adicionarNodo(temp.getDato());
            temp= temp.getSiguiente();
        }
        return listaCopia;
    }

    public boolean validarExistenciaCoordenadas(CoordenadaDTO[] coordenadas)
    {
        if(cabeza !=null)
        {
            NodoDE temp = cabeza;
            while(temp != null)
            {
                for(CoordenadaDTO coord: coordenadas)
                {
                    if(((DistribucionBarcoDTO) temp.getDato()).validarExistenciaCoordenada(coord))
                    {
                        return true;
                    }
                }
                temp= temp.getSiguiente();
            }
        }
        return false;
    }


}