package com.example.Frontend.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@Route("")
public class MainView extends VerticalLayout {
    private final RestTemplate restTemplate;

    public  MainView(RestTemplate restTemplate){
        this.restTemplate = restTemplate;

        TextField inputField = new TextField("Ingrese Cédula o RUC");
        Button checkContribuyenteButton = new Button("Verificar Contribuyente");
        Button checkPuntosButton = new Button("Verificar Puntos Licencia");

        checkContribuyenteButton.addClickListener(event ->{
            try{
                String numeroRuc = inputField.getValue();
                if (numeroRuc.length()!=13){
                    throw new RuntimeException();
                }
                boolean esContribuyente = verificarContribuyente(numeroRuc);
                Notification.show("Es contribuyente "+ esContribuyente);

            }catch (Exception e){
                Notification.show("Error. Ingrese un Ruc por favor");
            }
        });

        checkPuntosButton.addClickListener(event -> {
            try {
                String cedula = inputField.getValue();
                if (cedula.length()!=10){
                    throw new RuntimeException();
                }
                int puntos = verificarPuntos(cedula);
                Notification.show("Puntos de licencia: "+ puntos);
            }catch (Exception e){
                Notification.show("Error. Ingrese una cedula por favor");
            }
        });

        add(inputField, checkContribuyenteButton, checkPuntosButton);
    }

    private boolean verificarContribuyente(String numeroRuc){
        String url = "http://localhost:8080/api/sri/contribuyente/"+ numeroRuc;
        return restTemplate.getForObject(url, Boolean.class);
    }

    private int verificarPuntos(String cedula){
        String url = "http://localhost:8080/api/ant/puntos/" + cedula;
        return restTemplate.getForObject(url, Integer.class);
    }


}