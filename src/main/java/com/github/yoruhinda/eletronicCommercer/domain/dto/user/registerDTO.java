package com.github.yoruhinda.eletronicCommercer.domain.dto.user;

import com.github.yoruhinda.eletronicCommercer.domain.entity.enumerated.UserRoleEnumerated;

public record registerDTO(String username, String password, UserRoleEnumerated role) {
}
