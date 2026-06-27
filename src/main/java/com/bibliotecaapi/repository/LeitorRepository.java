package com.bibliotecaapi.repository;

import com.bibliotecaapi.model.Leitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeitorRepository extends JpaRepository<Leitor, Long> {
}
