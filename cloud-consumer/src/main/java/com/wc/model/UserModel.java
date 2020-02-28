package com.wc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel implements Serializable {
    private static final long serialVersionUID = -6138139990388077800L;
    private Integer id;
    private Integer groupId;
    private String name;
    private String address;
}
