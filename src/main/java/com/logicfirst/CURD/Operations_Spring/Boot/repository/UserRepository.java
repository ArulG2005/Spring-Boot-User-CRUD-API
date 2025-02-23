package com.logicfirst.CURD.Operations_Spring.Boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logicfirst.CURD.Operations_Spring.Boot.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

}
