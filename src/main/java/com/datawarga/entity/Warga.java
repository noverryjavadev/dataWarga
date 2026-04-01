package com.datawarga.entity;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;



@Data
@Builder
@Table(name = "tabel_warga")
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Where(clause = "deleted = false")
public class Warga implements Serializable {

    private static final long serialVersionUID = 5442758614953087116L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nama tidak boleh kosong")
    @Column(name = "nama", length = 255)
    private String nama;

    @NotEmpty(message = "Pekerjaan harus diisi")
    @Column(name = "pekerjaan", length = 255)
    private String pekerjaan;

    @Column(name = "deleted")
    private Boolean deleted = Boolean.FALSE;

}
