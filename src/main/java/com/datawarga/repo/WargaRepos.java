package com.datawarga.repo;

import com.datawarga.entity.Warga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WargaRepos extends JpaRepository<Warga, Long> {
    List<Warga> findByNamaContains(String nama);

    boolean existsByNama(String nama);
}