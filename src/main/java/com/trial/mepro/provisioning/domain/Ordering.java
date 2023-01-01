package com.trial.mepro.provisioning.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Ordering {
    @Id
    private Long id;

    @Column("name")
    private String name;
}
