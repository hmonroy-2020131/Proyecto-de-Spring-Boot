package com.eithanmonroy.webapp.biblioteca.service;

import java.util.List;

import com.eithanmonroy.webapp.biblioteca.model.Prestamo;

public interface IPrestamoService {
    public List<Prestamo> listaPrestamos();

    public Prestamo buscarPrestamoPorId(Long id);

    public Prestamo guardarPrestamo(Prestamo prestamo);

    public void eliminarPrestamo (Prestamo prestamo);
}
