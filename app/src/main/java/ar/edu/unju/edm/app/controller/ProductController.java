package ar.edu.unju.edm.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.app.model.Product;

@Controller
public class ProductController {

    // Lista de Productos agregados en tiempo de ejecucion
    private final List<Product> lista = new ArrayList<Product>();

    // Nombre de las variables (Datos) que se envian del Controlador al HTML
    private final String LISTA_PRODUCTO_KEY = "lista_productos";
    private final String PRODUCTO_KEY = "producto";

    /*
     * Como Acceder a las Paginas:
     * "/" = localhost:8080
     * "/agregar_producto" = localhost:8080/agregar_producto
     * "/detalles?p={ID}" = localhost:8080/detalles?p=1 (ID es un numero Entero)
     */
    @GetMapping("/")
    public ModelAndView listar() {
        ModelAndView vista = new ModelAndView("store"); // "home" es el nombre del HTML
        vista.addObject(LISTA_PRODUCTO_KEY, lista);
        return vista;
    }

    @GetMapping("/agregar_producto")
    public ModelAndView agregar() {
        Product objeto = new Product();
        ModelAndView vista = new ModelAndView("add_product"); // "add_product" es el nombre del HTML
        vista.addObject(PRODUCTO_KEY, objeto);
        return vista;
    }

    @GetMapping("/detalles?p={ID}")
    public ModelAndView ver(@PathVariable("ID") int ID) {
        if (ID > lista.size())
            return new ModelAndView("redirect:/"); // Posible ventana de Error (Por defecto vuelve al Inicio)
        Product objeto = lista.get(ID);
        ModelAndView vista = new ModelAndView("view_product"); // "view_product" es el nombre del HTML
        vista.addObject(PRODUCTO_KEY, objeto);
        return vista;
    }

    @PostMapping("/agregar_producto")
    public ModelAndView agregar(@ModelAttribute(PRODUCTO_KEY) Product objeto) {
        objeto.setID(lista.size());
        lista.add(objeto);
        ModelAndView vista = new ModelAndView("redirect:/");
        vista.addObject(LISTA_PRODUCTO_KEY, lista);
        return vista;
    }

}