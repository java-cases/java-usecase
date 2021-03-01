package com.usecase.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.usecase.dbsource")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DBSourceConfig {
    private Integer id;
    private String name;
    private String uri;
}
